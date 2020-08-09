package com.java.designPattern.factoryMethod;

import java.math.BigDecimal;

public class CombinationPizza extends Pizza {
    private BigDecimal price = new BigDecimal("12.5");

    @Override
    BigDecimal getPrice() {
        return price;
    }
}
