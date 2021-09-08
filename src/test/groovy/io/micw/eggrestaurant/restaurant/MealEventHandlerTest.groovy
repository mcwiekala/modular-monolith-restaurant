package io.micw.eggrestaurant.restaurant

import io.micw.eggrestaurant.commons.EggType
import io.micw.eggrestaurant.commons.EventBus
import io.micw.eggrestaurant.commons.EventBusImpl
import spock.lang.Specification

class MealEventHandlerTest extends Specification {

    EventBus eventBus = new EventBusImpl();
    MealRepository mealRepository = new InMemoryMealRepository();

    RestaurantEventPublisher restaurantEventPublisher = new RestaurantEventPublisher(eventBus)
    OrderRepository orderRepository = new InMemoryOrderRepository()
    Waiter waiter = new Waiter(restaurantEventPublisher, orderRepository)

    MealEventHandler mealEventHandler = new MealEventHandler(mealRepository, waiter)

    def "check events"() {
        given:
        UUID customerOrderId = UUID.randomUUID();
        MealWasDeliveredEvent event = new MealWasDeliveredEvent(customerOrderId, EggType.SCRAMBLED)
        eventBus.register(mealEventHandler);
        when:
        eventBus.dispatch(event)
        then:
//        TODO: id coupling!
        Meal meal = mealRepository.getMeal(customerOrderId)
        meal.eggType == EggType.SCRAMBLED
    }

}
