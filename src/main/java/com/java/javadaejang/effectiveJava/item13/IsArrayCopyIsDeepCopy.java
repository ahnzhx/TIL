package com.java.javadaejang.effectiveJava.item13;

public class IsArrayCopyIsDeepCopy implements Cloneable{
    private String arrayName = "sonnie's array";
    private int[] integerArray = {0,3,5,6,7};

    public String getArrayName() {
        return arrayName;
    }

    public int[] getIntegerArray() {
        return integerArray;
    }

    @Override
    protected IsArrayCopyIsDeepCopy clone() {
        IsArrayCopyIsDeepCopy clonedValue = null;
        try {
            clonedValue = (IsArrayCopyIsDeepCopy) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        clonedValue.integerArray = integerArray.clone();
        return clonedValue;
    }
}
