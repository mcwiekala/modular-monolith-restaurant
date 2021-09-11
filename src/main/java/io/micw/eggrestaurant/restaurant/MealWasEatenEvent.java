package io.micw.eggrestaurant.restaurant;

import io.micw.eggrestaurant.commons.DomainEvent;
import io.micw.eggrestaurant.commons.EggType;
import lombok.Value;

import java.util.UUID;

@Value
public class MealWasEatenEvent implements DomainEvent {

    UUID eventId = UUID.randomUUID();;
//    UUID customerOrderId;

    public MealWasEatenEvent() {
    }

    public MealWasEatenEvent(UUID customerOrderId) {
//        this.customerOrderId = customerOrderId;
    }

}
