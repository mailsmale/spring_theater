package ua.epam.spring.hometask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.epam.spring.hometask.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
