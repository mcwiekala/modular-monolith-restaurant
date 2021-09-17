package io.micw.eggrestaurant.wash;

import io.micw.eggrestaurant.restaurant.DishDeliveredToSinkEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class InMemoryDishDeliveredEventRepository implements DishDeliveredEventRepository {

    Map<UUID, DishDeliveredToSinkEvent> map = new HashMap();

    @Override
    public void saveEvent(DishDeliveredToSinkEvent event) {
        map.put(event.getEventId(), event);
    }

    @Override
    public DishDeliveredToSinkEvent getEvent(UUID eventId) {
        return map.get(eventId);
    }
}
