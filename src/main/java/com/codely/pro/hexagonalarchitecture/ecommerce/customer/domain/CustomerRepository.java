package com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain;

import java.util.Optional;

public interface CustomerRepository {
    Customer save(Customer customer);
    Optional<Customer> findById(Integer id);
}
