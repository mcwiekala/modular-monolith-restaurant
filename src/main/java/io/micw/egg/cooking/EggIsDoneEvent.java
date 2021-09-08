package io.micw.egg.cooking;

import io.micw.egg.commons.DomainEvent;
import io.micw.egg.commons.EggType;
import lombok.Value;

import java.util.UUID;

@Value
class EggIsDoneEvent implements DomainEvent {

    private UUID eventId;
    private EggType eggType;

}
