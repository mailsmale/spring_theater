package shape.component;

import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape {

    Double radius;
    Double circumference;

    public Circle(final Double radius, final Double circumference) {
        this.radius = radius;
        this.circumference = circumference;
    }

    @Override
    public Double getRadius() {
        return radius;
    }

    @Override
    public void setRadius(final Double radius) {
        this.radius = radius;
    }

    @Override
    public Double getCircumference() {
        return circumference;
    }

    @Override
    public void setCircumference(final Double circumference) {
        this.circumference = circumference;
    }
}
