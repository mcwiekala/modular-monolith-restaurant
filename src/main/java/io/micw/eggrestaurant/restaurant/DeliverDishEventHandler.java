package io.micw.eggrestaurant.restaurant;

import com.google.common.collect.Sets;
import io.micw.eggrestaurant.commons.EventBus;
import io.micw.eggrestaurant.commons.Subscribable;

import java.util.Set;

class DeliverDishEventHandler implements Subscribable<MealWasEatenEvent> {

    public static final Set<Class> SUPPORTED_EVENTS = Sets.newHashSet(MealWasEatenEvent.class);
    EventBus eventBus;

    @Override
    public void handle(MealWasEatenEvent domainEvent) {
        eventBus.dispatch(new DishDeliveredToSinkEvent(domainEvent.getCustomerOrderId()));
    }

    @Override
    public Set<Class> supports() {
        return SUPPORTED_EVENTS;
    }

}
