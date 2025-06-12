package com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.findAll;

import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.Query;

import java.util.List;

public record FindAllCustomerQuery(List<String> customerIds) implements Query {
}
