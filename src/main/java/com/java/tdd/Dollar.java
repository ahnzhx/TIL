package com.java.tdd;

import java.awt.event.MouseEvent;

public class Dollar extends Money {

    Dollar(int amount, String currency) {
        super(amount, currency);
    }

    Money times(int multiplier){
        return Money.dollar(amount * multiplier);
    }

}
