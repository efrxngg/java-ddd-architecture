package com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.find;

import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.Customer;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.Response;

public record CustomerResponse(Integer id, String name) implements Response {
    public static CustomerResponse fromAgregate(Customer customer) {
        return new CustomerResponse(customer.getId().value(), customer.getName().value());
    }
}
