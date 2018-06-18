package aop;

import aop.aspect.AuditoriumPerformanceCounterAspect;
import aop.component.Auditorium;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aop.component.Performance;
import aop.configuration.PerformanceConfiguration;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PerformanceConfiguration.class)
public class PerformanceTesting {

    @Autowired
    Performance sitcomHouseOfCarts;

    @Autowired
    AuditoriumPerformanceCounterAspect auditoriumPerformanceCounterAspect;

    @Autowired
    Auditorium auditorium;

    @Test
    public void performanceTesting() {
        auditorium.setPerformance(sitcomHouseOfCarts);
        auditorium.performEvent(sitcomHouseOfCarts);
        auditorium.perform();
        auditorium.perform();
        Integer actual = auditoriumPerformanceCounterAspect.getPerformanceCounter().get(sitcomHouseOfCarts
                .getPerformanceName());
        assertThat(actual).isEqualTo(3);
    }

}
