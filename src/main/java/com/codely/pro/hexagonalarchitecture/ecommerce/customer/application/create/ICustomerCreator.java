package com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.create;

import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerId;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerName;

public interface ICustomerCreator {
    void create(CustomerId id, CustomerName name);
}
