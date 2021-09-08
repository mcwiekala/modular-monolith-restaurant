package io.micw.eggrestaurant.commons;

import java.util.UUID;

public interface DomainEvent {

    UUID getEventId();

}
