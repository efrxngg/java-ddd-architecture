package com.codely.pro.hexagonalarchitecture.shared.infrastructure.bus.command;

import com.codely.pro.hexagonalarchitecture.shared.domain.bus.command.Command;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.command.CommandBus;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.command.CommandHandler;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.command.CommandHandlerExecutionError;
import lombok.RequiredArgsConstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InMemoryCommandBus implements CommandBus {

    private final CommandHandlersInformation information;
    private final ApplicationContext context;


    @Override
    public void dispatch(Command command) throws CommandHandlerExecutionError {
        try {
            Class<? extends CommandHandler> commandHandlerClass = information.search(command.getClass());
            CommandHandler commandHandler = context.getBean(commandHandlerClass);
            commandHandler.handle(command);
        } catch (Exception e) {
            throw new CommandHandlerExecutionError(e);
        }
    }

}
