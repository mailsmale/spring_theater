package dessert.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import dessert.annotaion.conditional.annotation.InStock;
import dessert.component.Cookie;

@Configuration
// @ComponentScan(basePackageClasses = Dessert.class)
@Profile("dev")
public class DessertConfiguration {

    // @Bean
    // public Dessert cake() {
    // return new Cake();
    // }
    //
    // @Bean
    // @Qualifier(value = "iceCream")
    // public Dessert iceCream() {
    // return new IceCream();
    // }

    @Bean
    @InStock
    // @Conditional(InStockCondition.class)
    //@Profile("dev")
    public Cookie cookie() {
        return new Cookie();
    }

}
