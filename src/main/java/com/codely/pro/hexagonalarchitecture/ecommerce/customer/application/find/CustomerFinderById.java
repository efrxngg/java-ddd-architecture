package com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.find;

import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.Customer;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerFinderByIdDomain;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerFinderById implements ICustomerFinderById {

    private final CustomerFinderByIdDomain finder;

    public CustomerFinderById(CustomerRepository finder) {
        this.finder = new CustomerFinderByIdDomain(finder);
    }

    public Customer find(Integer id) {
        return finder.find(id);
    }

}
