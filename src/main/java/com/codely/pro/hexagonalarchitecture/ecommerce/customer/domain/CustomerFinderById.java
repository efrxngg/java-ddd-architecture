package com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain;

import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.Customer;

public interface CustomerFinderById {
    Customer find(CustomerId id);
}
