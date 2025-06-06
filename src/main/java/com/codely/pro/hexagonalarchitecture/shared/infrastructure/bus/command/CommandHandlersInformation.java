package com.codely.pro.hexagonalarchitecture.shared.infrastructure.bus.command;

import com.codely.pro.hexagonalarchitecture.shared.domain.bus.command.Command;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.command.CommandHandler;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.command.CommandNotRegisterException;
import org.reflections.Reflections;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class CommandHandlersInformation {
    Map<Class<? extends Command>, Class<? extends CommandHandler>> indexedCommandHandlers;

    public CommandHandlersInformation() {
        String PATH_TO_SEARCH_SERVICES = "com.codely.pro.hexagonalarchitecture";
        Reflections reflections = new Reflections(PATH_TO_SEARCH_SERVICES);
        Set<Class<? extends CommandHandler>> clases = reflections.getSubTypesOf(CommandHandler.class);
        indexedCommandHandlers = formatHandlers(clases);
    }

    private Map<Class<? extends Command>, Class<? extends CommandHandler>> formatHandlers(Set<Class<? extends CommandHandler>> commandHandlers) {
        Map<Class<? extends Command>, Class<? extends CommandHandler>> handlers = new HashMap<>();
        for (Class<? extends CommandHandler> commandHandler : commandHandlers) {
            ParameterizedType paramType = (ParameterizedType) commandHandler.getGenericInterfaces()[0];
            Class<? extends Command> commandClass = (Class<? extends Command>) paramType.getActualTypeArguments()[0];

            handlers.put(commandClass, commandHandler);
        }

        return handlers;
    }

    public Class<? extends CommandHandler> search(Class<? extends Command> commandClass) throws CommandNotRegisterException {
        Class<? extends CommandHandler> commandHandler = indexedCommandHandlers.get(commandClass);

        if (commandHandler == null) {
            throw new CommandNotRegisterException(commandClass);
        }

        return commandHandler;
    }

}
