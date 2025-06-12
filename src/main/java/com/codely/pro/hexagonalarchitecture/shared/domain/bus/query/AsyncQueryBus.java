package com.codely.pro.hexagonalarchitecture.shared.domain.bus.query;

import java.util.concurrent.Future;

public interface AsyncQueryBus {
    Future<Response> ask(Query query) throws QueryHandlerExecutionError;
}
