package dessert.component;


import org.springframework.stereotype.Component;

import dessert.annotaion.conditional.annotation.InStock;
import dessert.annotaion.qualifier.Creamy;
import dessert.annotaion.qualifier.Cruspy;


@Component
@Cruspy
@Creamy
@InStock
public class Cookie implements Dessert {

}
