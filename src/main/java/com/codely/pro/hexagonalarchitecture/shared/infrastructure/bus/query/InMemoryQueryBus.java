package com.codely.pro.hexagonalarchitecture.shared.infrastructure.bus.query;

import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InMemoryQueryBus implements QueryBus {

    private final QueryHandlersInformation information;
    private final ApplicationContext context;

    @Override
    public Response ask(Query query) throws QueryHandlerExecutionError {
        try {
            Class<? extends QueryHandler> queryHandlerClass = information.search(query.getClass());
            QueryHandler handler = context.getBean(queryHandlerClass);
            return handler.handle(query);
        } catch (Throwable error) {
            throw new QueryHandlerExecutionError(error);
        }
    }

}
