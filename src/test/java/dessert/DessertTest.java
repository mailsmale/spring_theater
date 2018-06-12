package dessert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import dessert.annotaion.qualifier.Creamy;
import dessert.annotaion.qualifier.Cruspy;
import dessert.component.AbstractDessert;
import dessert.component.Cookie;
import dessert.component.Dessert;
import dessert.component.DessertEater;
import dessert.config.DessertConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DessertConfiguration.class)
@ActiveProfiles("dev")
public class DessertTest {

    private static final Logger LOG = LoggerFactory.getLogger(DessertTest.class.getSimpleName());

    @Autowired
    @Creamy
    @Cruspy
    Dessert dessert1;
    //
    @Autowired
    @Creamy
    @Cruspy
    Dessert dessert2;

    @Autowired
    DessertEater dessertEater1;
    @Autowired
    DessertEater dessertEater2;

    @Autowired
    Cookie cookie;

    @Test
    public void foo() {
        Stream.of(dessert1, dessert2)
                .forEach(dessert -> LOG.info(String.format("%s: %s", dessert.toString(), dessert.eat())));
        assertThat(dessert1).as("Desserts should be not equal").isNotEqualTo(dessert2);
        LOG.info(String.format("%s", dessertEater1.eatDessert()));
        LOG.info(String.format("%s", dessertEater2.eatDessert()));
        LOG.info(String.format("%s", dessertEater2.<AbstractDessert> getDessert().getProductName()));

        assertThat(dessertEater1.<AbstractDessert> getDessert()).as("Desserts should be not equal")
                .isNotEqualTo(dessertEater2.<AbstractDessert> getDessert());
    }

}
