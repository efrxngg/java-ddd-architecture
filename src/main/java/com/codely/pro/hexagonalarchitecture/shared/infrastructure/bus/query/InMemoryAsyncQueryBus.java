package com.codely.pro.hexagonalarchitecture.shared.infrastructure.bus.query;

import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
@RequiredArgsConstructor
public class InMemoryAsyncQueryBus implements AsyncQueryBus {

    private final QueryHandlersInformation information;
    private final ApplicationContext context;
    private final ThreadPoolTaskExecutor executor;

    @Override
    public Future<Response> ask(Query query) throws QueryHandlerExecutionError {
        try {
            Class<? extends QueryHandler> queryHandlerClass = information.search(query.getClass());
            QueryHandler handler = context.getBean(queryHandlerClass);

            return executor.submit(() -> handler.handle(query));
        } catch (Throwable error) {
            throw new QueryHandlerExecutionError(error);
        }
    }

}
