package aop.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

import aop.aspect.Audience;
import aop.aspect.AuditoriumPerformanceCounterAspect;
import aop.aspect.CriticAspect;
import aop.aspect.EncoreableIntroducer;
import aop.component.Auditorium;
import aop.component.CriticismEngine;
import aop.component.CriticismEngineImpl;
import aop.component.Performance;
import aop.component.SitcomHouseOfCarts;
import aop.component.SitcomIRobot;

@Configuration
@ComponentScan(basePackageClasses = { aop.component.Performance.class,
        aop.aspect.AuditoriumPerformanceCounterAspect.class })
/*
 * Need to be used if the aspects are declared via the @nnot@tions
 * 
 * @EnableAspectJAutoProxy
 */
@ImportResource("classpath*:aop/aop.xml")
public class PerformanceConfiguration {

}
