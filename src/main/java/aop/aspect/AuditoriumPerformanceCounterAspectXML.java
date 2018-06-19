package aop.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aop.component.Auditorium;
import aop.component.Performance;

public class AuditoriumPerformanceCounterAspectXML {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass().getName());
    private Map<String, Integer> performanceCounter = new HashMap<String, Integer>();

    public void performancePointcut1() {
    }

    public void performancePointcut2(final Performance performance) {
    }

    public void aroundPerformance1(ProceedingJoinPoint jp) {
        Performance performance = ((Auditorium) jp.getTarget()).getPerformance();
        aroundPerformance(performance, jp);
    }

    public void aroundPerformance2(ProceedingJoinPoint jp, final Performance performance) {
        aroundPerformance(performance, jp);
    }

    private void aroundPerformance(final Performance performance, final ProceedingJoinPoint proceedingJoinPoints) {
        final int playCount = getPlayCount((performance).getPerformanceName());
        final int currentPlayTime = playCount + 1;
        LOG.info(String.format("The track %s is has already been played %d times. Playing it the %d time",
                (performance).getPerformanceName(), playCount, currentPlayTime));
        performanceCounter.put((performance).getPerformanceName(), currentPlayTime);
        try {
            proceedingJoinPoints.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private Integer getPlayCount(final String performanceName) {
        return performanceCounter.containsKey(performanceName) ? performanceCounter.get(performanceName)
                : 0;
    }

    public Map<String, Integer> getPerformanceCounter() {
        return performanceCounter;
    }
}
