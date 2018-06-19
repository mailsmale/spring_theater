package aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import aop.component.DefaultEncoreable;
import aop.component.Encoreable;

@Aspect
@Component
public class EncoreableIntroducer {

    @DeclareParents(value = "aop.component.Performance+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
