package io.micw.eggrestaurant.restaurant;

import io.micw.eggrestaurant.commons.DomainEvent;
import io.micw.eggrestaurant.commons.EventBus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class RestaurantEventPublisher {

    EventBus eventBus;

    public RestaurantEventPublisher(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    void publish(DomainEvent event) {
        eventBus.dispatch(event);
    }
}
