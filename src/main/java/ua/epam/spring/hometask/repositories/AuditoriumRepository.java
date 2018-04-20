package ua.epam.spring.hometask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.epam.spring.hometask.domain.Auditorium;


public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
    Auditorium findByName(String name);
}
