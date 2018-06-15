package dessert.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import dessert.annotaion.conditional.annotation.InStock;
import dessert.annotaion.qualifier.Creamy;
import dessert.annotaion.qualifier.Cruspy;

@Component
@InStock
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // works for ComponentScan
public class Cookie extends AbstractDessert {

    public Cookie(@Value("${cookie.product.name}") final String productName) {
        super(productName);
    }
//    public Cookie(@Value("#{1}") final String productName) {
//        super(productName);
//    }

}
