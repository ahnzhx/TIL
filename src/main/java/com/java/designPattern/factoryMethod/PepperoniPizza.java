package com.java.designPattern.factoryMethod;

import java.math.BigDecimal;

public class PepperoniPizza extends Pizza {
    private BigDecimal price = new BigDecimal("8.4");

    @Override
    BigDecimal getPrice() {
        return price;
    }
}
