package com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.find;

import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.Query;

public record FindCustomerQuery(String id) implements Query {
}
