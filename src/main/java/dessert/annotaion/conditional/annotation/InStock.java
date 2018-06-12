package dessert.annotaion.conditional.annotation;


import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dessert.annotaion.conditional.condition.InStockCondition;


@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(InStockCondition.class)
public @interface InStock {

}
