package com.codely.pro.hexagonalarchitecture.ecommerce.customer.domain;

import com.codely.pro.hexagonalarchitecture.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.Map;

public class CustomerCreationDomainEvent extends DomainEvent {
    private final Integer id;
    private final String name;

    public CustomerCreationDomainEvent(String agregateId, Integer id, String name, String eventId, String ocurrendOn) {
        super(agregateId, null, null);
        this.id = id;
        this.name = name;
    }

    @Override
    public DomainEvent fromPrimitives(String agregateId, Map<String, Serializable> body, String eventId, String ocurrendOn) {

        return new CustomerCreationDomainEvent(
                agregateId,
                Integer.valueOf((String) body.get("id")) ,
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

    public Integer id() {
        return id;
    }

    public String name() {
        return name;
    }
}
