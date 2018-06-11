package dessert.component;

import org.springframework.stereotype.Component;

import dessert.annotaion.qualifier.Creamy;

@Component
//@Qualifier(value = "soft")
@Creamy
public class Cake implements Dessert {

}
