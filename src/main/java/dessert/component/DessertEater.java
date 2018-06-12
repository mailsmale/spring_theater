package dessert.component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import dessert.annotaion.qualifier.Creamy;
import dessert.annotaion.qualifier.Cruspy;

public class DessertEater {

    @Autowired
    @Creamy
    @Cruspy
    private Dessert dessert;

    public String eatDessert(){
        return dessert.eat();
    }

    public <T> T getDessert() {
        return (T) dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }
}
