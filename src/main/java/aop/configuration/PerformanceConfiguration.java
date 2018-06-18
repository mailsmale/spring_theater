package aop.configuration;

import aop.aspect.Audience;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import aop.aspect.AuditoriumPerformanceCounterAspect;
import aop.aspect.EncoreableIntroducer;
import aop.component.Auditorium;
import aop.component.Performance;
import aop.component.SitcomHouseOfCarts;
import aop.component.SitcomIRobot;

@Configuration
@ComponentScan(basePackageClasses = { aop.component.Performance.class,
        aop.aspect.AuditoriumPerformanceCounterAspect.class })
@EnableAspectJAutoProxy
@ImportResource("classpath*:aop/aop.xml")
public class PerformanceConfiguration {

    @Bean
    Audience audience(){
        return new Audience();
    }

    @Bean
    AuditoriumPerformanceCounterAspect auditoriumPerformanceCounterAspect() {
        return new AuditoriumPerformanceCounterAspect();
    }

    @Bean
    Auditorium auditorium() {
        return new Auditorium();
    }

    @Bean
    EncoreableIntroducer encoreableIntroducer() {
        return new EncoreableIntroducer();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Performance sitcomHouseOfCarts() {
        return new SitcomHouseOfCarts();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Performance sitcomIRobot() {
        return new SitcomIRobot();
    }

}
