package com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain;

import com.codely.pro.hexagonalarchitecture.shared.domain.agregate.AggregateRoot;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Customer extends AggregateRoot {
    private CustomerId id;
    private CustomerName name;

    public Customer(CustomerId id, CustomerName name) {
        this.id = id;
        this.name = name;
    }

    // name constructor
    public static Customer create(CustomerId id, CustomerName name) {
        Customer customer = new Customer(id, name);
        customer.record(new CustomerCreationDomainEvent(id.value().toString(), id.value(), name.value(), null, null));

        return customer;
    }

}
