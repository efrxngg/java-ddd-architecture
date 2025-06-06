package com.codely.pro.hexagonalarchitecture.shared.infrastructure.bus.query;

import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.Query;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.QueryHandler;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.query.QueryNotRegisteredError;
import org.reflections.Reflections;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class QueryHandlersInformation {
    Map<Class<? extends Query>, Class<? extends QueryHandler>> indexedQueryHandlers;

    public QueryHandlersInformation() {
        String PATH_TO_SEARCH_QUERYS = "com.codely.pro.hexagonalarchitecture";
        Reflections reflections = new Reflections(PATH_TO_SEARCH_QUERYS);
        Set<Class<? extends QueryHandler>> clases = reflections.getSubTypesOf(QueryHandler.class);
        indexedQueryHandlers = formatHandlers(clases);
    }

    private Map<Class<? extends Query>, Class<? extends QueryHandler>> formatHandlers(Set<Class<? extends QueryHandler>> QueryHandlers) {
        Map<Class<? extends Query>, Class<? extends QueryHandler>> handlers = new HashMap<>();
        for (Class<? extends QueryHandler> QueryHandler : QueryHandlers) {
            ParameterizedType paramType = (ParameterizedType) QueryHandler.getGenericInterfaces()[0];
            Class<? extends Query> QueryClass = (Class<? extends Query>) paramType.getActualTypeArguments()[0];

            handlers.put(QueryClass, QueryHandler);
        }

        return handlers;
    }

    public Class<? extends QueryHandler> search(Class<? extends Query> queryClass) throws QueryNotRegisteredError {
        Class<? extends QueryHandler> queryHandler = indexedQueryHandlers.get(queryClass);

        if (queryHandler == null) {
            throw new QueryNotRegisteredError(queryClass);
        }

        return queryHandler;
    }
}
