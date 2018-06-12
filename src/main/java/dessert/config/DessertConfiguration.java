package dessert.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import dessert.annotaion.conditional.annotation.InStock;
import dessert.annotaion.qualifier.Creamy;
import dessert.annotaion.qualifier.Cruspy;
import dessert.component.AbstractDessert;
import dessert.component.Cake;
import dessert.component.Cookie;
import dessert.component.Dessert;
import dessert.component.DessertEater;
import dessert.component.IceCream;

// @ComponentScan(basePackageClasses = Dessert.class)
@Profile("dev")
@Configuration
@PropertySource("classpath:/dessert/app.properties")
public class DessertConfiguration {

    @Autowired
    Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Dessert cake() {
        return new Cake();
    }

    @Bean
    @Qualifier(value = "iceCream")
    public Dessert iceCream() {
        return new IceCream();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Profile("dev")
    public DessertEater dessertEater() {
        return new DessertEater();
    }

    @Bean
    @InStock
    @Scope(proxyMode = ScopedProxyMode.DEFAULT, scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Profile("dev")
    @Creamy
    @Cruspy
    public AbstractDessert cookie() {
        return new Cookie(environment.getProperty("cookie.product.name", "N O T F O U N D"));
    }

}
