package aop;

import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

import aop.aspect.AuditoriumPerformanceCounterAspectXML;
import aop.aspect.CriticAspect;
import aop.aspect.EncoreableIntroducer;
import aop.component.Auditorium;
import aop.component.Performance;
import aop.configuration.PerformanceConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PerformanceConfiguration.class)
public class PerformanceTesting {

    @Autowired
    Performance sitcomHouseOfCarts;

    @Autowired
    AuditoriumPerformanceCounterAspectXML auditoriumPerformanceCounterAspectXML;

    @Autowired
    Auditorium auditorium;

    @Autowired
    EncoreableIntroducer encoreableIntroducer;

    @Autowired
    CriticAspect criticAspect;

    @Test
    public void performanceTesting() {
        auditorium.setPerformance(sitcomHouseOfCarts);
        auditorium.performEvent(sitcomHouseOfCarts);
        auditorium.perform();
        auditorium.perform();
        Integer actual = auditoriumPerformanceCounterAspectXML.getPerformanceCounter()
                .get(sitcomHouseOfCarts.getPerformanceName());
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void delcareParentsAnnotationTesting() {
        assertThat(Stream.of(sitcomHouseOfCarts.getClass().getDeclaredMethods())
                .filter(method -> method.getName().equals("performEncore")).findFirst().isPresent()).isEqualTo(true);
    }

}
