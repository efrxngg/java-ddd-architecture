package com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain;

import com.codely.pro.hexagonalarchitecture.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

public class CustomerCreationDomainEvent extends DomainEvent {
    private final UUID id;
    private final String name;

    public CustomerCreationDomainEvent(String agregateId, UUID id, String name, String eventId, String ocurrendOn) {
        super(agregateId, null, null);
        this.id = id;
        this.name = name;
    }

    @Override
    public DomainEvent fromPrimitives(String agregateId, Map<String, Serializable> body, String eventId, String ocurrendOn) {

        return new CustomerCreationDomainEvent(
                agregateId,
                UUID.fromString((String) body.get("id")) ,
                (String) body.get("name"),
                eventId,
                ocurrendOn);
    }

    @Override
    public String eventName() {
        return "customer.created";
    }

    @Override
    public Map<String, Serializable> toPrimitives() {
        return Map.of(
                "id", id,
                "name", name
        );
    }

    public UUID id() {
        return id;
    }

    public String name() {
        return name;
    }
}
