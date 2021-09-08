package io.micw.egg.restaurant;

import io.micw.egg.commons.DomainEvent;
import io.micw.egg.commons.EggType;
import lombok.Value;

import java.util.UUID;

@Value
public class MealWasDeliveredEvent implements DomainEvent {

    private UUID eventId;
    private EggType eggType;

    public MealWasDeliveredEvent(EggType eggType) {
        this.eggType = eggType;
        this.eventId = UUID.randomUUID();
    }

}
