package dessert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dessert.annotaion.conditional.annotation.InStock;
import dessert.annotaion.qualifier.Creamy;
import dessert.annotaion.qualifier.Cruspy;
import dessert.component.Dessert;
import dessert.config.DessertConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DessertConfiguration.class)
@ActiveProfiles("dev")
public class DessertTest {

    private static final Logger LOG = LoggerFactory.getLogger(DessertTest.class.getSimpleName());

    @Autowired
    @Creamy
    @Cruspy
    Dessert dessert;

    @Test
    public void foo() {
        LOG.info(dessert.eat());
    }

}
