package com.codely.pro.hexagonalarchitecture.ecommerce.customer.application.create;

import com.codely.pro.hexagonalarchitecture.shared.domain.bus.command.Command;

public record CreateCustomerCommand(String id, String name) implements Command {
}
