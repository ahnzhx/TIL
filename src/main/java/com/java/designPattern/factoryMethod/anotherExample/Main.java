package com.java.designPattern.factoryMethod.anotherExample;

public class Main {

    public static void main(String[] args) {
        Factory factory = new IdCardFactory();
        Product card1 = factory.create("소현");
        Product card2 = factory.create("주현");
        Product card3 = factory.create("정현");
        card1.use();
        card2.use();
        card3.use();
    }

}
