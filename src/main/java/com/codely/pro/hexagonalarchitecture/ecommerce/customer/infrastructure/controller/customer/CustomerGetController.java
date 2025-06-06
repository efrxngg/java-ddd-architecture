package com.codely.pro.hexagonalarchitecture.ecommerce.customer.infrastructure.controller.customer;

import com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.find.CustomerResponse;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.find.FindCustomerQuery;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerNotFound;
import com.codely.pro.hexagonalarchitecture.shared.domain.DomainError;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.command.CommandBus;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.QueryBus;
import com.codely.pro.hexagonalarchitecture.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CustomerGetController extends ApiController {

    public CustomerGetController(CommandBus commandBus, QueryBus queryBus) {
        super(commandBus, queryBus);
    }

    @GetMapping("/customers/{id}")
    public CustomerResponse findById(@PathVariable Integer id) {
        return ask(new FindCustomerQuery(id));
    }

    @Override
    public Map<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return Map.of(
                CustomerNotFound.class, HttpStatus.NOT_FOUND
        );
    }
}
