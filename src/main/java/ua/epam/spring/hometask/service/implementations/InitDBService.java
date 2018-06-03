package ua.epam.spring.hometask.service.implementations;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.service.AuditoriumService;
import ua.epam.spring.hometask.service.EventService;

import java.time.LocalDate;

@Transactional
@Service("initDBService")
public class InitDBService {

    private static final Logger LOG = LoggerFactory.getLogger(InitDBService.class.getSimpleName());
    @Autowired
    StatisticServiceImp statisticServiceImp;
    @Autowired
    private AuditoriumService auditoriumService;
    @Autowired
    private EventService eventService;
    //TODO check why this method is not working
    public void init() {
        Auditorium auditorium = new Auditorium();
        auditorium.setNumberOfSeats(50);
        final String auditoriumName = "testAuditorium";
        auditorium.setName(auditoriumName);
        auditoriumService.save(auditorium);
        String eventName = "Comedy club";
        Event event = new Event(eventName);
        event = eventService.save(event);

    }

}
