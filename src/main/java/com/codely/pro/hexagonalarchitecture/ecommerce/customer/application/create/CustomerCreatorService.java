package com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.create;

import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.Customer;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerCreator;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerId;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerName;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerRepository;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.event.EventBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerCreatorService implements CustomerCreator {
    private final CustomerRepository repository;
    private final EventBus eventBus;

    public void create(CustomerId id, CustomerName name) {
        Customer customer = Customer.create(id, name);
        repository.save(customer);
        System.out.println("Customer created: " + customer);
        eventBus.publish(customer.pullDomainEvents());
    }

}
