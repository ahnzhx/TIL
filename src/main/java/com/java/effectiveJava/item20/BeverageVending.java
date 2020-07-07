package com.java.effectiveJava.item20;

public class BeverageVending extends AbstractVending implements Vending {
    @Override
    public void chooseProduct() {
        System.out.println("choose menu");
        System.out.println("coke");
        System.out.println("energy drink");
    }
}
