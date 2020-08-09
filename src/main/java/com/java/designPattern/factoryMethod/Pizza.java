package com.java.designPattern.factoryMethod;

import javax.transaction.NotSupportedException;
import java.math.BigDecimal;

public abstract class Pizza {
    abstract BigDecimal getPrice();

    enum PizzaType{
        COMBINATION, CHEESE, PEPPERONI;
    }

    public static Pizza pizzaFactory(PizzaType pizzaType) throws NotSupportedException {
        switch (pizzaType){
            case PEPPERONI:
                return new PepperoniPizza();
            case CHEESE:
                return new CheesePizza();
            case COMBINATION:
                return new CombinationPizza();

        }
        throw new NotSupportedException("The pizza type " + pizzaType.toString() + " is not on the menu");
    }

}
