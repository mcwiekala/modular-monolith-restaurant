package io.micw.eggrestaurant.cooking;

import io.micw.eggrestaurant.commons.EventBus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class CookingEventPublisher {

    EventBus eventBus;

    public CookingEventPublisher(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    void publish(EggIsDoneEvent event){
        eventBus.dispatch(event);
    }

}
