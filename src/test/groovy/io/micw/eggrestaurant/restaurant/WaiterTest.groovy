package io.micw.eggrestaurant.restaurant

import io.micw.eggrestaurant.commons.EggType
import io.micw.eggrestaurant.commons.EventBus
import io.micw.eggrestaurant.commons.EventBusImpl
import spock.lang.Specification

class WaiterTest extends Specification {

    EventBus eventBus = new EventBusImpl();
    MealRepository mealRepository = new InMemoryMealRepository();
//    MealEventHandler mealEventHandler = new MealEventHandler(mealRepository)

    RestaurantEventPublisher restaurantEventPublisher = new RestaurantEventPublisher(eventBus)
    OrderRepository orderRepository = new InMemoryOrderRepository()

    Waiter waiter = new Waiter(restaurantEventPublisher, orderRepository)

    def "create the order"() {
        given:
        Visitor mike = new Visitor("Mike Smith")

        when:
        Order orderFromMike = mike.callWaiter(waiter, EggType.SUNNY_SIDE_UP)

        then:
        def order = orderRepository.getOrder(orderFromMike.getUuid())
        EggType.SUNNY_SIDE_UP == order.eggType
    }
}
