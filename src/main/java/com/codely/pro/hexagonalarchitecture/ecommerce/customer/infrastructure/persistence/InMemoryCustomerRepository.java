package com.codely.pro.hexagonalarchitecture.ecommerce.customer.infrastructure.persistence;

import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.Customer;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    Set<Customer> customers = new LinkedHashSet<>();

    @Override
    public Customer save(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return customers.stream()
                .filter(customer -> customer.getId().value().equals(id))
                .findFirst();
    }
}
