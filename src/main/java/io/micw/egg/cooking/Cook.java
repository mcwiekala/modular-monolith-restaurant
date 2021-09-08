package io.micw.egg.cooking;

import io.micw.egg.commons.EggType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class Cook {

    CookingEventPublisher cookingEventPublisher;

    public Cook(CookingEventPublisher cookingEventPublisher) {
        this.cookingEventPublisher = cookingEventPublisher;
    }

    void makeMeal(EggType eggType) {
        log.info("Cooking: " + eggType + " egg!");
        cook();
        EggIsDoneEvent event = new EggIsDoneEvent(eggType);
        cookingEventPublisher.publish(event);
    }

    private void cook() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
