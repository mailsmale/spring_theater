package shape.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import shape.component.Circle;

@Configuration
@PropertySource("classpath:/shape/app.properties")
public class ShapeConfiguration {

    @Autowired
    Environment environment;

    @Bean
    public Circle circle(@Value("#{environment.getProperty('circle.radius', T(java.lang.Double))}") final Double radius,
            @Value("#{2 * T(java.lang.Math).PI * environment.getProperty('circle.radius', T(java.lang.Double))}") final Double circumference) {
        return new Circle(radius, circumference);
    }

}
