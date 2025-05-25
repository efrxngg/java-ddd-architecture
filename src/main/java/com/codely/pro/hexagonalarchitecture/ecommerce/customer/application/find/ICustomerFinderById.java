package com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.find;

import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.Customer;

public interface ICustomerFinderById {
    Customer find(Integer id);
}
