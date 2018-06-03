package ua.epam.spring.hometask.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.domain.Event;

import java.time.LocalDateTime;

/**
 * @author Yuriy_Tkach
 */
@Service
@Transactional
public interface EventService extends AbstractDomainObjectService<Event> {

    @Nullable Double getEventPrice (@NotNull Auditorium auditorium,  @NotNull Event event, @NotNull
            LocalDateTime localDateTime);

    void assignAuditorium(LocalDateTime dateTime, Event event, Auditorium auditorium, Double price);

    /*
     * Finding all events that air on specified date range
     * 
     * @param from Start date
     * 
     * @param to End date inclusive
     * 
     * @return Set of events
     */
    // public @Nonnull Set<Event> getForDateRange(@Nonnull LocalDate from,
    // @Nonnull LocalDate to);

    /*
     * Return events from 'now' till the the specified date time
     * 
     * @param to End date time inclusive s
     * 
     * @return Set of events
     */
    // public @Nonnull Set<Event> getNextEvents(@Nonnull LocalDateTime to);

}
