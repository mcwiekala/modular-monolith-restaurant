package io.micw.eggrestaurant.restaurant;

import io.micw.eggrestaurant.commons.DomainEvent;
import io.micw.eggrestaurant.commons.EggType;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.UUID;

@Value
class MealWasEatenEvent implements DomainEvent {

    UUID eventId = UUID.randomUUID();
    UUID customerOrderId;

}
