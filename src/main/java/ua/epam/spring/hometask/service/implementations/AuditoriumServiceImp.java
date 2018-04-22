package ua.epam.spring.hometask.service.implementations;

import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.repositories.AuditoriumRepository;
import ua.epam.spring.hometask.service.AuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service("auditoriumServiceImp")
@Transactional
public class AuditoriumServiceImp implements AuditoriumService {

    @Autowired
    AuditoriumRepository auditoriumRepository;

    @Override
    public Auditorium save(@Nonnull Auditorium object) {
        return auditoriumRepository.save(object);
    }

    @Override
    public void remove(@Nonnull Auditorium object) {
        auditoriumRepository.delete(object);
    }

    @Override
    public Optional<Auditorium> getById(@Nonnull Long id) {
        return auditoriumRepository.findById(id);
    }

    @Nonnull
    @Override
    public Set<Auditorium> getAll() {
        return auditoriumRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        return auditoriumRepository.findByName(name);
    }
}
