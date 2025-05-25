package com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain;

public class CustomerNotFound extends RuntimeException {

    public CustomerNotFound() {
        super("Customer not found");
    }

}
