package aop.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class Audience {

    Logger LOG = LoggerFactory.getLogger(Audience.class.getName());

    @Pointcut("execution(* aop.component.Auditorium.perform(..)))")
    public void perform() {
    }

    @Before("perform()")
    public void silenceCellPhones() {
        LOG.info("Please silence cell phones!");
    }

    @Before("perform()")
    public void takeSeats() {
        LOG.info("Please take your seat!");
    }

    @AfterReturning("perform()")
    public void applause() {
        LOG.info("<CLAP CLAP CLAP>!");
    }

    @AfterThrowing("perform()")
    public void demandRefund() {
        LOG.info("Demanding a refund!");
    }

//    @Around("perform()")
//    public void aroundPerformance(ProceedingJoinPoint jp) {
//        try {
//            LOG.info("Please silence cell phones!");
//            LOG.info("Please take your seat!");
//            jp.proceed();
//            LOG.info("<CLAP CLAP CLAP>!");
//        } catch (Throwable throwable) {
//            LOG.info("Demanding a refund!");
//        }
//    }

}
