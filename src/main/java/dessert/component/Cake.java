package dessert.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import dessert.annotaion.qualifier.Creamy;
import dessert.annotaion.qualifier.Cruspy;
import dessert.annotaion.qualifier.Fruity;
import dessert.annotaion.qualifier.Soft;
import lombok.Getter;
import lombok.Setter;

@Component
//@Qualifier(value = "soft")
@Soft
@Fruity
@Creamy

public class Cake extends AbstractDessert {

    public Cake( @Value("#{123}") final String productName){
        super(productName);
    }

}
