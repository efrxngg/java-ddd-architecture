package com.codely.pro.hexagonalarchitecture.shared.domain.agregate;

import com.codely.pro.hexagonalarchitecture.shared.domain.bus.event.DomainEvent;

import java.util.LinkedList;
import java.util.List;

public abstract class AggregateRoot {
    private List<DomainEvent> domainEvents = new LinkedList<>();

    public final List<DomainEvent> pullDomainEvents() {
        var events = domainEvents;
        domainEvents = new LinkedList<>();

        return events;
    }

    public void record(DomainEvent domainEvent) {
        domainEvents.add(domainEvent);
    }

}
