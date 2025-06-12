package com.codely.pro.hexagonalarchitecture.shared.infrastructure.bus.command;

import com.codely.pro.hexagonalarchitecture.shared.domain.bus.command.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InMemoryAsyncCommandBus implements AsyncCommandBus {

    private final CommandHandlersInformation information;
    private final ApplicationContext context;


    @Async
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
