package com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.findAll;

import com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.find.CustomerResponse;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.Response;

import java.util.List;

public record AllCustomerResponse(List<CustomerResponse> customers) implements Response {
}
