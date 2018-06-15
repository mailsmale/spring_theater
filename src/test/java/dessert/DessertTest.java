package dessert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import dessert.annotaion.conditional.annotation.InStock;
import dessert.annotaion.qualifier.Cold;
import dessert.annotaion.qualifier.Creamy;
import dessert.annotaion.qualifier.Cruspy;
import dessert.annotaion.qualifier.Fruity;
import dessert.annotaion.qualifier.Soft;
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

    @Autowired
    @Fruity
    @Cold
    @Creamy
    @Qualifier("iceBerg")
    Dessert iceCream;


    @Autowired
    @Soft
    @Fruity
    @Creamy
    Dessert cake;

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
        LOG.info(String.format("IceCream product name: %s", iceCream.getProductName()));
        LOG.info(String.format("Cake product name: %s", cake.getProductName()));

        LOG.info(String.format("DessertEater1.getDessertProductName(): %s", dessertEater1.getDessertProductName()));
        LOG.info(String.format("DessertEater1.getPI(): %s", dessertEater1.getPI()));


    }

}
