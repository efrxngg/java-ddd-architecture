package com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.findAll;

import com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.find.CustomerResponse;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerId;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.QueryHandler;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.QueryHandlerExecutionError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindAllCustomerQueryHandler implements QueryHandler<FindAllCustomerQuery, AllCustomerResponse> {

    private final CustomerFindAllOnListService finderAll;

    @Override
    public AllCustomerResponse handle(FindAllCustomerQuery query) throws QueryHandlerExecutionError {
        List<CustomerId> customerIds = query.customerIds().stream()
                .map(id -> new CustomerId(UUID.fromString(id)))
                .toList();
        List<CustomerResponse> retrievedCustomers = finderAll.findAllInList(customerIds);

        return new AllCustomerResponse(retrievedCustomers);
    }

}
