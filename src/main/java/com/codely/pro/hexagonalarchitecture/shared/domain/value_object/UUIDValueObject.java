package com.codely.pro.hexagonalarchitecture.shared.domain.value_object;

import java.util.UUID;


public abstract class UUIDValueObject {
    private final UUID value;

    public UUIDValueObject(UUID value) {
        this.value = value;
    }

    public UUID value() {
        return value;
    }
}
