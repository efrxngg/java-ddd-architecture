package com.codely.pro.hexagonalarchitecture.shared.domain.bus.event;

import java.util.List;

public interface EventBus {
    void publish(List<DomainEvent> events);
}
