package io.micw.eggrestaurant.restaurant

import io.micw.eggrestaurant.commons.EggType
import io.micw.eggrestaurant.commons.EventBus
import io.micw.eggrestaurant.commons.EventBusImpl
import spock.lang.Specification

class WaiterImplTest extends Specification {

    EventBus eventBus = new EventBusImpl();
    MealRepository mealRepository = new InMemoryMealRepository();
//    MealEventHandler mealEventHandler = new MealEventHandler(mealRepository)

    RestaurantEventPublisher restaurantEventPublisher = new RestaurantEventPublisher(eventBus)
    OrderRepository orderRepository = new InMemoryOrderRepository()
    CustomerRepository customerRepository = new InMemoryCustomerRepository()
    Waiter waiter = new WaiterImpl(restaurantEventPublisher, orderRepository, customerRepository)

    def "create the order"() {
        given:
        Visitor mike = new Visitor("Mike Smith")

        when:
        Order orderFromMike = mike.callWaiter(waiter, EggType.SUNNY_SIDE_UP)

        then:
        def order = orderRepository.getOrder(orderFromMike.getOrderId())
        EggType.SUNNY_SIDE_UP == order.eggType
    }

    def "deliver meal to customer"() {
        given:
        EggType eggType = EggType.FLIPPED
        Visitor mike = new Visitor("Mike Smith")
        Customer mikeCustomer = new Customer(mike, waiter)
        Order mikesOrder = new Order(mikeCustomer.customerId, eggType)
        Meal mikesMeal = new Meal(mikesOrder.orderId, eggType)

        mikesOrder.setMealId(mikesMeal.mealId)
        orderRepository.saveOrder(mikesOrder)
        customerRepository.saveCustomer(mikeCustomer)

        when:
        Boolean result = waiter.deliverMeal(mikesMeal)

        then:
        result
    }
}
