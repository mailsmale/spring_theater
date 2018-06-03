package ua.epam.spring.hometask.service.implementations;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.domain.AuditoriumEvent;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.repositories.AuditoriumEventRepository;
import ua.epam.spring.hometask.repositories.AuditoriumRepository;
import ua.epam.spring.hometask.repositories.EventRepository;
import ua.epam.spring.hometask.service.EventService;

@Service
public class EventServiceImp implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    AuditoriumEventRepository auditoriumEventRepository;

    @Autowired
    AuditoriumRepository auditoriumRepository;

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        return eventRepository.findByName(name);
    }

    @Nullable
    @Override
    public Double getEventPrice(final Auditorium auditorium, final Event event,
            final LocalDateTime localDateTime) {
        return auditoriumEventRepository
                .findByAuditoriumAndEventAndDate(auditorium, event, localDateTime).get(0).getEventPrice();
    }

    @Override
    public Event save(@Nonnull Event object) {
        return eventRepository.save(object);
    }

    @Override
    public void remove(@Nonnull Event object) {
        eventRepository.delete(object);
    }

    @Override
    public Optional<Event> getById(@Nonnull Long id) {
        return eventRepository.findById(id);
    }

    @Nonnull
    @Override
    public Collection<Event> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public void assignAuditorium(LocalDateTime dateTime, Event event, Auditorium auditorium,
            Double price) {
        AuditoriumEvent auditoriumAssigned = event.assignAuditorium(dateTime, auditorium, price);
        eventRepository.save(event);
        auditoriumEventRepository.save(auditoriumAssigned);
        auditoriumRepository.save(auditoriumAssigned.getAuditorium());
    }
}
