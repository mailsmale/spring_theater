package ua.epam.spring.hometask.service.implementations;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.AuditoriumEvent;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.repositories.EventRepository;
import ua.epam.spring.hometask.repositories.TicketRepository;
import ua.epam.spring.hometask.repositories.UserRepository;
import ua.epam.spring.hometask.service.BookingService;
import ua.epam.spring.hometask.service.DiscountService;

@Service("bookingServiceImp")
public class BookingServiceImp implements BookingService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    DiscountService discountService;

    @Override
    public double getTicketsPrice(@Nonnull Event event, @Nonnull LocalDateTime dateTime,
            @Nullable User user, @Nonnull Set<Long> seats) {
        AuditoriumEvent auditoriumEvent = event.getAuditoriums().stream()
                .filter(e -> e.getDate().equals(dateTime)).findFirst().get();
        Double eventPriceWithoutDiscount = auditoriumEvent.getEventPrice();
        int size = seats.size();
        byte discount = discountService.getDiscount(user, event, dateTime, size);
        return (100 - discount) / 100 * eventPriceWithoutDiscount * size;
    }

    @Override
    public void bookTickets(@Nonnull Set<Ticket> tickets, User user) {
        tickets.stream().forEach(ticket -> {
            long ticketSeat = ticket.getSeat();
            ticket.getEvent().getAuditoriums().stream().filter(
                    eventAuditorium -> eventAuditorium.getDate().equals(ticket.getDateTime()))
                    .forEach(eventAuditorium -> eventAuditorium.getAuditorium().getAllSeats().stream()
                            .filter(seat -> seat.getId().equals(ticketSeat))
                            .forEach(seat -> seat.setAvailability(false)));
            ticketRepository.save(ticket);
        });
        Optional.ofNullable(user).ifPresent((pUser) -> {
            pUser.getTickets().addAll(tickets);
            userRepository.save(user);
        });
    }

    @Nonnull
    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event,
            @Nonnull LocalDateTime dateTime) {
        return ticketRepository.findByEventAndDateTime(event, dateTime);
    }
}
