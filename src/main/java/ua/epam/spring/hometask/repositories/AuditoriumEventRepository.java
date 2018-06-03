package ua.epam.spring.hometask.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.domain.AuditoriumEvent;
import ua.epam.spring.hometask.domain.Event;

public interface AuditoriumEventRepository extends JpaRepository<AuditoriumEvent, Long> {
    List<AuditoriumEvent> findByAuditoriumAndEventAndDate(final Auditorium auditorium, final Event event,
            final LocalDateTime localDateTime);

    AuditoriumEvent findByName(String name);
}
