package io.micw.eggrestaurant.restaurant;

import io.micw.eggrestaurant.commons.DomainEvent;
import lombok.Value;

import java.util.UUID;

@Value
class DishDeliveredToSinkEvent implements DomainEvent {

    UUID eventId = UUID.randomUUID();
    UUID customerOrderId;

}
