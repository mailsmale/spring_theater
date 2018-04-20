package ua.epam.spring.hometask.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.repositories.AuditoriumRepository;
import ua.epam.spring.hometask.service.AuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuditoriumServiceImp implements AuditoriumService {

    @Autowired
    AuditoriumRepository auditoriumRepository;

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
