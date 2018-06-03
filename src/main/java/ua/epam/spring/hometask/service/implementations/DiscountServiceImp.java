package ua.epam.spring.hometask.service.implementations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.springframework.stereotype.Service;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.DiscountService;

@Service("discountServiceImp")
public class DiscountServiceImp implements DiscountService {

    private final Byte dayRangeForDiscount = 5;
    private final Byte everyTenthTicketDiscount = 50;
    private final Byte defaultValueOfDiscount = 0;

    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event,
            @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        ChronoUnit days = ChronoUnit.DAYS;
        Function<LocalDate, Boolean> checkBirthdayDiscount = birthDay -> airDateTime.toLocalDate()
                    .isAfter((birthDay.minus(dayRangeForDiscount, days)))
                    && airDateTime.toLocalDate().isBefore((birthDay.plus(dayRangeForDiscount, days)));;
        Boolean availableDiscountForBirthday = Optional.ofNullable(user).map(userL -> userL.getBirthDay()).map
                (checkBirthdayDiscount).orElse(false);
        boolean availableDiscountForTenthTicket = user.isAvailableDiscountForTenthTicket() || numberOfTickets >=10;
        Byte discount = Optional.of(availableDiscountForBirthday).filter(birthDiscount -> birthDiscount)
                .map(birthDiscount -> dayRangeForDiscount)
                .orElse(Optional.of(availableDiscountForTenthTicket).filter(t -> t)
                        .map(t -> everyTenthTicketDiscount).orElse(defaultValueOfDiscount));
        return discount;
    }
}
