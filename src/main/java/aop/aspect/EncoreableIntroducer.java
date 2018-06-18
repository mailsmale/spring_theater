package aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

import aop.component.Encoreable;

@Aspect
public class EncoreableIntroducer {

    @DeclareParents(value = "aop.component.Performance+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
