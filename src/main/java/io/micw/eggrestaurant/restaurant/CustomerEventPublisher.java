package io.micw.eggrestaurant.restaurant;

import io.micw.eggrestaurant.commons.EventBus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class CustomerEventPublisher {

    EventBus eventBus;

    public CustomerEventPublisher(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    void publish(MealWasEatenEvent event) {
        eventBus.dispatch(event);
    }
}
