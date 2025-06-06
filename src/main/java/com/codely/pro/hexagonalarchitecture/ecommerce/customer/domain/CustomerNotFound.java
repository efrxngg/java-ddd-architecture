package com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain;

import com.codely.pro.hexagonalarchitecture.shared.domain.DomainError;

public class CustomerNotFound extends DomainError {

    public CustomerNotFound() {
        super("404", " Cliente no encontrado");
    }

}
