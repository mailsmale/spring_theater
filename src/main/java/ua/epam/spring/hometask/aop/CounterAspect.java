package ua.epam.spring.hometask.aop;

/**
 * CounterAspect - count how many times each event was accessed by name, how many times its prices
 * were queried, how many times its tickets were booked. Store counters in map for now (later could
 * be replaced by DB dao
 *
 * Знакомство с АОП https://habrahabr.ru/post/114649/
 *
 * Руководство по Spring. АОП в Spring с использованием аннотаций (пример приложения).
 * http://proselyte.net/tutorials/spring-tutorial-full-version/aop-with-spring/aop-example-annotations/
 *
 * Spring Auto scanning components https://www.mkyong.com/spring/spring-auto-scanning-components/
 *
 * Introduction to Pointcut Expressions in Spring
 * http://www.baeldung.com/spring-aop-pointcut-tutorial
 *
 */

import java.util.logging.Logger;
import java.util.stream.Stream;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.EventStatisticUnit;
import ua.epam.spring.hometask.repositories.AuditoriumEventRepository;
import ua.epam.spring.hometask.repositories.EventRepository;
import ua.epam.spring.hometask.service.implementations.StatisticServiceImp;

@Aspect
public class CounterAspect {

    @Autowired
    StatisticServiceImp statisticServiceImp;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    AuditoriumEventRepository auditoriumEventRepository;

    Logger LOG = Logger.getLogger(CounterAspect.class.getSimpleName());


    // @Pointcut("execution(* *..EventService.getByName(..))")
    @Pointcut("execution(ua.epam.spring.hometask.domain.Event *..EventService.getByName(..))")
    public void selectAllMethodsAvaliable() {
    }

    @Pointcut("execution(ua.epam.spring.hometask.domain.Event *..EventService.getEventPrice(..))")
    public void findAllExecutionsOfGettingPriceForEvent() {
    }


    @After("selectAllMethodsAvaliable()")
    public void afterSelectAllMethodsAvaliable() {

    }

    @Around("selectAllMethodsAvaliable()")
    public Event aroundSelectAllMethodsAvaliable(ProceedingJoinPoint pjp) throws Throwable {
        Event event = this.logAndProceedTheMethod(String.valueOf(pjp.getArgs()[0]), pjp);
        EventStatisticUnit eventStatisticUnit = statisticServiceImp.findByEvent(event);
        statisticServiceImp.increaseNumberOfGettingPriceForEvent(eventStatisticUnit);
        return event;
    }

    @Around("findAllExecutionsOfGettingPriceForEvent()")
    public Double aroundfindAllExecutionsOfFindByAuditoriumAndEvent(ProceedingJoinPoint pjp) throws Throwable {
        Event eventFromArgs = (Event) Stream.of(pjp.getArgs())
                .filter(object -> object.getClass().equals(Event.class)).findFirst().get();
        Double eventPrice = this.logAndProceedTheMethod(eventFromArgs.getName(), pjp);
        EventStatisticUnit eventStatisticUnit = statisticServiceImp.findByEvent(eventFromArgs);
        statisticServiceImp.increaseNumberOfSearchByName(eventStatisticUnit);
        return eventPrice;
    }

    private <T> T logAndProceedTheMethod(String eventName, ProceedingJoinPoint pjp) throws Throwable {
        String message = "%s executing of the method with the following signature: %s \n. Event name: %s";
        LOG.info(String.format(message, "Starting", pjp.getSignature(), eventName));
        T resultOfExecution = (T) pjp.proceed();
        LOG.info(String.format(message, "Ending", pjp.getSignature(), eventName));
        return resultOfExecution;
    }

}
