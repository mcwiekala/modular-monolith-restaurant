package io.micw.eggrestaurant.cooking;

import io.micw.eggrestaurant.commons.EggType;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
class Cook {

    CookingEventPublisher cookingEventPublisher;

    public Cook(CookingEventPublisher cookingEventPublisher) {
        this.cookingEventPublisher = cookingEventPublisher;
    }

    void makeMeal(UUID customerOrderId, EggType eggType) {
        log.info("Cooking: " + eggType + " egg!");
        cook();
        EggIsDoneEvent event = new EggIsDoneEvent(customerOrderId, eggType);
        cookingEventPublisher.publish(event);
    }

    private void cook() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
