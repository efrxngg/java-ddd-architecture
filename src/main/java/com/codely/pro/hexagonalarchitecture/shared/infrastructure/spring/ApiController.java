package com.codely.pro.hexagonalarchitecture.shared.infrastructure.spring;

import com.codely.pro.hexagonalarchitecture.shared.domain.DomainError;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.command.Command;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.command.CommandBus;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.command.CommandHandlerExecutionError;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.Query;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.QueryBus;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.QueryHandlerExecutionError;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Map;

@RequiredArgsConstructor
public abstract class ApiController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    protected void dispatch(Command command) throws CommandHandlerExecutionError {
        commandBus.dispatch(command);
    }

    protected <R> R ask(Query query) throws QueryHandlerExecutionError {
        return queryBus.ask(query);
    }

    abstract public Map<Class<? extends DomainError>, HttpStatus> errorMapping();

}
