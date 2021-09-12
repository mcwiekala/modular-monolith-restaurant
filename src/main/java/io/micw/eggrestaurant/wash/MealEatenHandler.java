package io.micw.eggrestaurant.wash;

import com.google.common.collect.Sets;
import io.micw.eggrestaurant.commons.Subscribable;
import io.micw.eggrestaurant.restaurant.DishDeliveredToSinkEvent;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
@Value
class MealEatenHandler implements Subscribable<DishDeliveredToSinkEvent> {

    public static final Set<Class> SUPPORTED_EVENTS = Sets.newHashSet(DishDeliveredToSinkEvent.class);
    DishWasher dishWasher;

    @Override
    public void handle(DishDeliveredToSinkEvent domainEvent) {
        dishWasher.addDishesToSink(new DirtyDishes(domainEvent.getCustomerOrderId()));
    }

    @Override
    public Set<Class> supports() {
        return SUPPORTED_EVENTS;
    }
}
