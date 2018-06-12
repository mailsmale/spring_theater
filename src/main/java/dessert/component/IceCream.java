package dessert.component;

import org.springframework.stereotype.Component;

import dessert.annotaion.conditional.annotation.InStock;
import dessert.annotaion.qualifier.Cold;
import dessert.annotaion.qualifier.Creamy;
import dessert.annotaion.qualifier.Fruity;
import lombok.experimental.Accessors;

@Component
//@Qualifier("cold")
@Fruity
@Cold
@Creamy
@InStock
public class IceCream extends AbstractDessert {

}
