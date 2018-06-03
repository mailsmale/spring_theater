package ua.epam.spring.hometask.service.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.EventStatisticUnit;
import ua.epam.spring.hometask.repositories.EventAccessStatisticRepository;
import ua.epam.spring.hometask.service.EntityStatisticService;

@Service
public class StatisticServiceImp implements EntityStatisticService {

    @Autowired
    EventAccessStatisticRepository eventAccessStatisticRepository;

    public EventStatisticUnit findByEvent(final Event event) {
        EventStatisticUnit byEvent = Optional
                .ofNullable(eventAccessStatisticRepository.findByEvent(event)).orElseGet(() -> {
                    EventStatisticUnit eventStatisticUnit = new EventStatisticUnit(event, 0, 0);
                    return eventAccessStatisticRepository.save(eventStatisticUnit);
                });
        return byEvent;
    }

    public void increaseNumberOfSearchByName(final EventStatisticUnit eventStatisticUnit) {
        eventAccessStatisticRepository.increaseNumberOfSearchByName(eventStatisticUnit);
    }

    public void increaseNumberOfGettingPriceForEvent(final EventStatisticUnit eventStatisticUnit) {
        eventAccessStatisticRepository.increaseNumberOfGettingPriceForEvent(eventStatisticUnit);
    }

}
