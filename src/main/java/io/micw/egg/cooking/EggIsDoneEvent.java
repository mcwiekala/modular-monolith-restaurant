package io.micw.egg.cooking;

import io.micw.egg.commons.DomainEvent;
import io.micw.egg.commons.EggType;
import lombok.Value;

import java.util.UUID;

@Value
public class EggIsDoneEvent implements DomainEvent {

    UUID eventId;
    EggType eggType;

    public EggIsDoneEvent(EggType eggType) {
        this.eggType = eggType;
        this.eventId = UUID.randomUUID();
    }
}
