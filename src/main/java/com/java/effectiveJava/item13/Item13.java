package com.java.effectiveJava.item13;

public class Item13 implements Cloneable{
    private String phoneNumber = "phoneNumber 123456";
    private String name = "sonnie's name is sonnie";

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getName() {
        return name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

//        return super.clone();
        return new Item13();
    }
}
