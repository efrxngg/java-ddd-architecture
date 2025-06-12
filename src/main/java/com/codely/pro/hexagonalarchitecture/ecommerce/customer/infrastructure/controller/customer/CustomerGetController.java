package com.codely.pro.hexagonalarchitecture.ecommerce.customer.infrastructure.controller.customer;

import com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.find.CustomerResponse;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.find.FindCustomerQuery;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.findAll.AllCustomerResponse;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.findAll.FindAllCustomerQuery;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerNotFound;
import com.codely.pro.hexagonalarchitecture.shared.domain.DomainError;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.command.CommandBus;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.QueryBus;
import com.codely.pro.hexagonalarchitecture.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CustomerGetController extends ApiController {

    public CustomerGetController(CommandBus commandBus, QueryBus queryBus) {
        super(commandBus, queryBus);
    }

    @GetMapping("/customers/{id}")
    public CustomerResponse findById(@PathVariable String id) {
        return ask(new FindCustomerQuery(id));
    }

    @GetMapping("/customers")
    public AllCustomerResponse findAll() {
        return ask(new FindAllCustomerQuery(List.of("618f5ffa-1d27-4e33-a789-470b9bb6d80e")));
    }

    @Override
    public Map<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return Map.of(
                CustomerNotFound.class, HttpStatus.NOT_FOUND
        );
    }
}
