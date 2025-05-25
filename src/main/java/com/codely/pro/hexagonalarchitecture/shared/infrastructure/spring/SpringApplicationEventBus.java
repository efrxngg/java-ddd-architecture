package com.codely.pro.hexagonalarchitecture.shared.infrastructure.spring;

import com.codely.pro.hexagonalarchitecture.shared.domain.bus.event.DomainEvent;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.event.EventBus;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
@RequiredArgsConstructor
public class SpringApplicationEventBus implements EventBus {

    private final ApplicationEventPublisher publisher;

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent event) {
        this.publisher.publishEvent(event);
    }

}
