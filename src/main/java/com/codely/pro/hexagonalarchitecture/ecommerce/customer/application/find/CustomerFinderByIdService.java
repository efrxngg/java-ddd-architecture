package com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.find;

import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.Customer;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerFinderById;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerFinderByIdDomain;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerId;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerFinderByIdService implements CustomerFinderById {

    private final CustomerFinderByIdDomain finder;

    public CustomerFinderByIdService(CustomerRepository finder) {
        this.finder = new CustomerFinderByIdDomain(finder);
    }

    @Override
    public Customer find(CustomerId id) {
        return finder.find(id);
    }

}
