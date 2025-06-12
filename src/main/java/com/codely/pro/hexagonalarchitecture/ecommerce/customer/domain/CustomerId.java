package com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain;

import com.codely.pro.hexagonalarchitecture.shared.domain.value_object.UUIDValueObject;

import java.util.UUID;

public final class CustomerId extends UUIDValueObject {
    public CustomerId(UUID value) {
        super(value);
    }
}
