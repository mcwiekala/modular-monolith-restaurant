package io.micw.eggrestaurant.restaurant;

import io.micw.eggrestaurant.commons.DomainEvent;
import io.micw.eggrestaurant.commons.EggType;
import lombok.Value;

import java.util.UUID;

@Value
public class EggWasOrderedEvent implements DomainEvent {

    UUID eventId;
    UUID customerOrderId;
    EggType eggType;

    public EggWasOrderedEvent(UUID customerOrderId, EggType eggType) {
        this.eventId = UUID.randomUUID();
        this.customerOrderId = customerOrderId;
        this.eggType = eggType;
    }

}
