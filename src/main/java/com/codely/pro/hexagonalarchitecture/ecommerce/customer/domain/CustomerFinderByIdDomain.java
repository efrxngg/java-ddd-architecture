package com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain;

public class CustomerFinderByIdDomain {
    private final CustomerRepository repository;

    public CustomerFinderByIdDomain(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer find(CustomerId id) {
        return repository
                .findById(id.value())
                .orElseThrow(CustomerNotFound::new);
    }
}
