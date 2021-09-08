package io.micw.egg.cooking;

import io.micw.egg.commons.EggType;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
class Cook {

    CookingEventPublisher cookingEventPublisher;

    void makeMeal(EggType eggType) {
        log.info("Cooking: " + eggType + " egg!");
        cook();
        EggIsDoneEvent event = new EggIsDoneEvent(UUID.randomUUID(), eggType);
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
