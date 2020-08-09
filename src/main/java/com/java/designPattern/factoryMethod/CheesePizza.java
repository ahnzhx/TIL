package com.java.designPattern.factoryMethod;

import java.math.BigDecimal;

public class CheesePizza extends Pizza {

    private BigDecimal price = new BigDecimal("10.3");

    @Override
    BigDecimal getPrice() {
        return price;
    }
}
