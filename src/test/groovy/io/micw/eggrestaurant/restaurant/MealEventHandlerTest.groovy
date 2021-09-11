package io.micw.eggrestaurant.restaurant

import io.micw.eggrestaurant.commons.EggType
import io.micw.eggrestaurant.commons.EventBus
import io.micw.eggrestaurant.commons.EventBusImpl
import spock.lang.Specification

class MealEventHandlerTest extends Specification {

    public static final EggType eggType = EggType.SCRAMBLED
    EventBus eventBus = new EventBusImpl();
    MealRepository mealRepository = new InMemoryMealRepository();

    RestaurantEventPublisher restaurantEventPublisher = new RestaurantEventPublisher(eventBus)
    OrderRepository orderRepository = new InMemoryOrderRepository()
    Waiter waiter = Mock(Waiter.class)

    MealEventHandler mealEventHandler = new MealEventHandler(orderRepository, mealRepository, waiter)

    def "check events"() {
        given:
        waiter.deliverMeal(_) >> true
        UUID customerId = UUID.randomUUID()
        Order order = new Order(customerId, eggType)
        orderRepository.saveOrder(order)
        MealWasDeliveredEvent event = new MealWasDeliveredEvent(order.getOrderId(), eggType)
        eventBus.register(mealEventHandler);
        when:
        eventBus.dispatch(event)
        then:
        Meal meal = mealRepository.getMeal(order.mealId)
        meal != null
    }

}
