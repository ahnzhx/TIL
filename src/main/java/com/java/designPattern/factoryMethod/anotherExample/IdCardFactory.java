package com.java.designPattern.factoryMethod.anotherExample;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class IdCardFactory extends Factory{
    private List<String> owners = new ArrayList<>();

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IdCard) product).getOwner());
    }

    @Override
    protected Product createProduct(String owner) {
        return new IdCard(owner);
    }
}
