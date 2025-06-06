package com.codely.pro.hexagonalarchitecture.ecommerce.customer.infrastructure.controller.customer;

import com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.create.CreateCustomerCommand;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.infrastructure.controller.customer.dto.CustomerCreate;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.infrastructure.controller.customer.dto.CustomerResponse;
import com.codely.pro.hexagonalarchitecture.shared.domain.DomainError;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.command.CommandBus;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.QueryBus;
import com.codely.pro.hexagonalarchitecture.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CustomerPostController extends ApiController {

    public CustomerPostController(CommandBus commandBus, QueryBus queryBus) {
        super(commandBus, queryBus);
    }

    @PostMapping("/customers")
    public CustomerResponse save(@RequestBody CustomerCreate customerCreate) {
        CreateCustomerCommand createCustomerCommand = new CreateCustomerCommand(
                customerCreate.id(), customerCreate.name());
        dispatch(createCustomerCommand);

        return null;
    }

    @Override
    public Map<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return Map.of();
    }
}
