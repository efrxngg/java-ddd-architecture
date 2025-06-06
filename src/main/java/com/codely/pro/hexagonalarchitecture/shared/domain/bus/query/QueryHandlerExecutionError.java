package com.codely.pro.hexagonalarchitecture.shared.domain.bus.query;

public class QueryHandlerExecutionError extends RuntimeException {
    public QueryHandlerExecutionError(Throwable throwable) {
        super(throwable);
    }
}
