package ua.epam.spring.hometask.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.epam.spring.hometask.domain.AuditoriumEvent;
import ua.epam.spring.hometask.repositories.AuditoriumEventRepository;
import ua.epam.spring.hometask.service.AuditoriumEventService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public class AuditoriumEventServiceImp implements AuditoriumEventService {

    @Autowired
    AuditoriumEventRepository auditoriumEventRepository;


    @Override
    public AuditoriumEvent save(@Nonnull AuditoriumEvent auditoriumEvent) {
        return auditoriumEventRepository.save(auditoriumEvent);
    }

    @Override
    public void remove(@Nonnull AuditoriumEvent object) {
        auditoriumEventRepository.delete(object);
    }

    @Override
    public Optional<AuditoriumEvent> getById(@Nonnull Long id) {
        return Optional.ofNullable(auditoriumEventRepository.getOne(id));
    }

    @Nonnull
    @Override
    public Collection<AuditoriumEvent> getAll() {
        return auditoriumEventRepository.findAll();
    }

    @Nullable
    @Override
    public AuditoriumEvent getByName(@Nonnull String name) {
        return auditoriumEventRepository.findByName(name);
    }
}
