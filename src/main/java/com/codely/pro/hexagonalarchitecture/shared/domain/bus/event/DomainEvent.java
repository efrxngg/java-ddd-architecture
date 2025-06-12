package com.codely.pro.hexagonalarchitecture.shared.domain.bus.event;

import com.codely.pro.hexagonalarchitecture.shared.domain.utils.DateUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public abstract class DomainEvent {

    private final String agregateId;
    private final String eventId;
    private final String ocurrendOn;

    public DomainEvent(String agregateId, String eventId, String ocurrendOn) {
        this.agregateId = agregateId;
        this.eventId = eventId == null ? UUID.randomUUID().toString() : eventId;
        this.ocurrendOn = ocurrendOn == null ? DateUtils.dateToString(LocalDateTime.now()) : ocurrendOn;
    }

    public abstract DomainEvent fromPrimitives(
            String agregateId,
            Map<String, Serializable> body,
            String eventId,
            String ocurrendOn);

    public abstract String eventName();

    public abstract Map<String, Serializable> toPrimitives();

    public String agregateId() {
        return agregateId;
    }

    public String eventId() {
        return eventId;
    }

    public String ocurrendOn() {
        return ocurrendOn;
    }
}
