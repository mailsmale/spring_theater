package aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aop.component.CriticismEngine;

@Aspect
@Component
public class CriticAspect {

    //@Autowired
    private CriticismEngine criticismEngine;

    @Autowired
    public void setCriticismEngine(final CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
