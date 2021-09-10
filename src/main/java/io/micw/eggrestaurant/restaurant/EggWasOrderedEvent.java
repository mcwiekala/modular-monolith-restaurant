package io.micw.eggrestaurant.restaurant;

import io.micw.eggrestaurant.commons.DomainEvent;
import io.micw.eggrestaurant.commons.EggType;
import lombok.Value;

import java.util.UUID;

@Value
public class EggWasOrderedEvent implements DomainEvent {

    UUID eventId = UUID.randomUUID();;
    UUID customerOrderId;
    EggType eggType;

    public EggWasOrderedEvent(UUID customerOrderId, EggType eggType) {
        this.customerOrderId = customerOrderId;
        this.eggType = eggType;
    }

}
