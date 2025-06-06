package com.codely.pro.hexagonalarchitecture.shared.domain.bus.command;

public class CommandHandlerExecutionError extends RuntimeException {
    public CommandHandlerExecutionError(Throwable throwable) {
        super(throwable);
    }
}
