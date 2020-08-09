package com.java.designPattern.factoryMethod;

import javax.transaction.NotSupportedException;

public class Main {
    public static void main(String[] args) throws NotSupportedException {
        System.out.println(Pizza.pizzaFactory(Pizza.PizzaType.CHEESE).getClass());
        System.out.println(Pizza.pizzaFactory(Pizza.PizzaType.COMBINATION).getClass());
        System.out.println(Pizza.pizzaFactory(Pizza.PizzaType.PEPPERONI).getClass());
    }
}
