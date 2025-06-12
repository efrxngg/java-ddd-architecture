package com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.find;

import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.Customer;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.Response;

import java.util.UUID;

public record CustomerResponse(UUID id, String name) implements Response {
    public static CustomerResponse fromAgregate(Customer customer) {
        return new CustomerResponse(customer.getId().value(), customer.getName().value());
    }
}
