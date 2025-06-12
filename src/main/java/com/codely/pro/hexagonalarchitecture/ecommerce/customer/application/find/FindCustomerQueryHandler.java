package com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.find;

import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.Customer;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerFinderById;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerId;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.QueryHandler;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.QueryHandlerExecutionError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindCustomerQueryHandler implements QueryHandler<FindCustomerQuery, CustomerResponse> {

    private final CustomerFinderById finder;

    @Override
    public CustomerResponse handle(FindCustomerQuery query) throws QueryHandlerExecutionError {
        Customer customer = finder.find(new CustomerId(UUID.fromString(query.id())));

        return CustomerResponse.fromAgregate(customer);
    }

}
