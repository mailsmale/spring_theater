package aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PerformanceAspects {

    @Pointcut("execution(* aop.component.Performance.perform(..))throws and bean('woodstock')")
    public void perform() {
    }

}
