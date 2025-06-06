package com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.create;

import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerCreator;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerId;
import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerName;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.command.CommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCustomerEventHandler implements CommandHandler<CreateCustomerCommand> {

    private final CustomerCreator customerCreator;

    @Override
    public void handle(CreateCustomerCommand command) {
        customerCreator.create(
                new CustomerId(command.id()),
                new CustomerName(command.name()
                ));
    }

}
