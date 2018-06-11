package dessert.component;

import org.springframework.stereotype.Component;

import dessert.annotaion.conditional.annotation.InStock;
import dessert.annotaion.qualifier.Cold;
import dessert.annotaion.qualifier.Creamy;
import dessert.annotaion.qualifier.Fruity;

@Component
//@Qualifier("cold")
@Fruity
@Cold
@Creamy
@InStock
public class IceCream implements Dessert {

}
