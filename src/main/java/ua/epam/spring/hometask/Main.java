package ua.epam.spring.hometask;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.service.AuditoriumService;
import ua.epam.spring.hometask.service.EventService;
import ua.epam.spring.hometask.service.implementations.InitDBService;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) {
        ConfigurableApplicationContext aspectContext = new ClassPathXmlApplicationContext(
                "aspectsContext.xml");
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        applicationContext.getBean(InitDBService.class).init();
        EventService eventService = applicationContext.getBean(EventService.class);
        AuditoriumService auditoriumService = applicationContext.getBean(AuditoriumService.class);
        Event comedyClubTestEvent = eventService.getByName("Comedy club");
        Auditorium testAuditorium = auditoriumService.getByName("testAuditorium");
        LocalDateTime dateTime = LocalDate.now().atTime(12, 00);
        eventService.assignAuditorium(dateTime, comedyClubTestEvent, testAuditorium, 100.00);
        eventService.getEventPrice(testAuditorium, comedyClubTestEvent, dateTime);
    }

}
