package io.micw.eggrestaurant.cooking;

import io.micw.eggrestaurant.commons.DomainEvent;
import io.micw.eggrestaurant.commons.EggType;
import lombok.Value;

import java.util.UUID;

@Value
public class EggIsDoneEvent implements DomainEvent {

    UUID eventId = UUID.randomUUID();;
    UUID customerOrderId;
    EggType eggType;

    public EggIsDoneEvent(UUID customerOrderId, EggType eggType) {
        this.customerOrderId = customerOrderId;
        this.eggType = eggType;
    }
}
