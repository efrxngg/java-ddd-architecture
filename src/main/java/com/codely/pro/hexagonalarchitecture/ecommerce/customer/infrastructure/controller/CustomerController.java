package com.codely.pro.hexagonalarchitecture.ecommerce.customer.infrastructure.controller;

import com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.create.CustomerCreatorService;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.find.CustomerFinderByIdService;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.Customer;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerId;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerName;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.infrastructure.controller.dto.CustomerCreate;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.infrastructure.controller.dto.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerCreatorService customerCreator;
    private final CustomerFinderByIdService customerFinderById;

    @PostMapping
    public CustomerResponse save(@RequestBody CustomerCreate customerCreate) {
        customerCreator.create(
                new CustomerId(customerCreate.id()),
                new CustomerName(customerCreate.name())
        );
        return null;
    }

    @GetMapping("{id}")
    public Customer findById(@PathVariable Integer id) {
        return customerFinderById.find(id);
    }

}
