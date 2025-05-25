package com.codely.pro.hexagonalarchitecture.shared.value_object;

public abstract class StringValueObject {
    private final String value;

    public StringValueObject(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
