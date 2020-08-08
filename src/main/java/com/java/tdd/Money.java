package com.java.tdd;

abstract class Money {
    protected int amount;

    static Money franc(int amount) {
        return new Franc(amount);
    }

    abstract Money times(int multiplier);

    static Dollar dollar(int amount) {
        return new Dollar(amount);
    }

    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount
                && getClass().equals(money.getClass());
    }
}
