package com.codely.pro.hexagonalarchitecture.shared.domain.bus.command;

public class CommandNotRegisterException extends Exception {
    public CommandNotRegisterException(Class<? extends Command> command) {
        super("The command %s hasn't a command handler associate".formatted(command.toString()));
    }
}
