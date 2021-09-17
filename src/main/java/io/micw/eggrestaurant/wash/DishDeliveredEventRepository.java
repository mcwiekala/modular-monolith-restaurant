package io.micw.eggrestaurant.wash;

import io.micw.eggrestaurant.restaurant.DishDeliveredToSinkEvent;

import java.util.UUID;

interface DishDeliveredEventRepository {

    void saveEvent(DishDeliveredToSinkEvent event);
    DishDeliveredToSinkEvent getEvent(UUID eventId);

}
