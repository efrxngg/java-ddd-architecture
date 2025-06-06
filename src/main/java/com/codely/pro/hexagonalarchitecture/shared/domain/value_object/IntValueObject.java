package com.codely.pro.hexagonalarchitecture.shared.domain.value_object;

public abstract class IntValueObject {
    private final Integer value;

    public IntValueObject(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return value;
    }

}
