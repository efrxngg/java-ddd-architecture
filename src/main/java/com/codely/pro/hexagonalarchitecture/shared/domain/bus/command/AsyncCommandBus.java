package com.codely.pro.hexagonalarchitecture.shared.domain.bus.command;

public interface AsyncCommandBus {
    void dispatch(Command command) throws CommandHandlerExecutionError;
}
