package com.codely.pro.hexagonalarchitecture.shared.domain.agregate;

import com.codely.pro.hexagonalarchitecture.shared.domain.bus.event.DomainEvent;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AggregateRoot {
    private List<DomainEvent> domainEvents;

    public final List<DomainEvent> pullDomainEvents() {
        var events = domainEvents;
        domainEvents = Collections.emptyList();

        return events;
    }

    public void record(DomainEvent... domainEvent) {
        domainEvents = Arrays.asList(domainEvent);
    }

}
