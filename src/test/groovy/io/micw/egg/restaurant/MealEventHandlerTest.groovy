package io.micw.egg.restaurant

import io.micw.egg.commons.EggType
import io.micw.egg.commons.EventBus
import io.micw.egg.commons.EventBusImpl
import spock.lang.Specification

class MealEventHandlerTest extends Specification {

    EventBus eventBus = new EventBusImpl();
    MealRepository mealRepository = new InMemoryMealRepository();
    MealEventHandler mealEventHandler = new MealEventHandler(mealRepository)

    def "check events"() {
        given:
        MealWasDeliveredEvent event = new MealWasDeliveredEvent(EggType.SCRAMBLED)
        eventBus.register(mealEventHandler);
        when:
        eventBus.dispatch(event)
        then:
        Meal meal = mealRepository.getMeal(event.getEventId())
        meal.eggType == EggType.SCRAMBLED
    }

}
