package shape;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import shape.component.Shape;
import shape.configuration.ShapeConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ShapeConfiguration.class)
public class ShapeTest {

    Logger Log = LoggerFactory.getLogger(ShapeTest.class.getSimpleName());

    @Autowired
    Shape circle;

    @Test
    public void testCircle() {
        Log.info(String.format("Circle circumference equals: %1$,.2f", circle.getCircumference()));
    }

}
