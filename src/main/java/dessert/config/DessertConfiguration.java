package dessert.config;

import dessert.component.IceCream;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import dessert.component.Cake;
import dessert.component.Dessert;

import javax.inject.Named;

@Configuration
@ComponentScan(basePackageClasses = Dessert.class)
public class DessertConfiguration {

    @Bean
    public Dessert cake() {
        return new Cake();
    }

    @Bean
    @Qualifier(value = "iceCream")
    public Dessert iceCream() {
        return new IceCream();
    }

}
