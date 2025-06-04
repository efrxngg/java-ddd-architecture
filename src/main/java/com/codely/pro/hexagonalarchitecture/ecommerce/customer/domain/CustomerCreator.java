package com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain;

import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerId;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerName;

public interface CustomerCreator {
    void create(CustomerId id, CustomerName name);
}
