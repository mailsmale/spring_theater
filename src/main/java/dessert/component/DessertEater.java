package dessert.component;


import com.google.common.primitives.Doubles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import dessert.annotaion.qualifier.Creamy;
import dessert.annotaion.qualifier.Cruspy;

public class DessertEater {

    //@Autowired
    @Creamy
    @Cruspy
    @Value("#{cookie}")
    private Dessert dessert;


    @Value("#{cookie?.getProductName()}")
    private String dessertProductName;

    @Value("#{T(java.lang.Math).PI}")
    private String PI;

    public String eatDessert(){
        return dessert.eat();
    }

    public <T> T getDessert() {
        return (T) dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public String getDessertProductName() {
        return dessertProductName;
    }

    public void setDessertProductName(String dessertProductName) {
        this.dessertProductName = dessertProductName;
    }

    public String getPI() {
        return PI;
    }

    public void setPI(final String PI) {
        this.PI = PI;
    }
}
