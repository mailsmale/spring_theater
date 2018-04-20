package ua.epam.spring.hometask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;

import java.time.LocalDateTime;
import java.util.Set;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Set<Ticket> findByEventAndDateTime(Event event, LocalDateTime localDateTime);
}
