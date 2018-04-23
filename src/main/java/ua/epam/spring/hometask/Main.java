package ua.epam.spring.hometask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.epam.spring.hometask.aop.CounterAspect;
import ua.epam.spring.hometask.service.EventService;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) {
        ConfigurableApplicationContext aspectContext = new ClassPathXmlApplicationContext(
                "aspectsContext.xml");
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        EventService eventServiceImp = applicationContext.getBean(EventService.class);
        eventServiceImp.getByName("Comedy club");
        eventServiceImp.getByName("Comedy club");
        eventServiceImp.getByName("Comedy club");
        LOG.info(String.valueOf(applicationContext.getBean(CounterAspect.class).getByNameCalledCount()));
        LOG.info("123");

    }

}
