package com.codely.pro.hexagonalarchitecture.ecommerce.notify.application.send;

import com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain.CustomerCreationDomainEvent;
import com.codely.pro.hexagonalarchitecture.shared.domain.bus.event.DomainEventSubscriber;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@DomainEventSubscriber({CustomerCreationDomainEvent.class})
public class SendHelloNotificationOnCustomerCreate {

    @EventListener
    public void on(CustomerCreationDomainEvent event) {
        System.out.printf("Listening::CustomerCreationDomainEvent: %s\n", event.toPrimitives());
    }

}
