package com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain;

public class CustomerFinderByIdDomain {
    private final CustomerRepository repository;

    public CustomerFinderByIdDomain(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer find(Integer id) {
        return repository.findById(id).orElseThrow(CustomerNotFound::new);
    }
}
