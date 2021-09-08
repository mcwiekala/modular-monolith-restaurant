package io.micw.egg.restaurant

import io.micw.egg.commons.EggType
import io.micw.egg.commons.EventBus
import io.micw.egg.commons.EventBusImpl
import spock.lang.Specification

class WaiterTest extends Specification {

    EventBus eventBus = new EventBusImpl();
    MealRepository mealRepository = new InMemoryMealRepository();
    MealEventHandler mealEventHandler = new MealEventHandler(mealRepository)

    RestaurantEventPublisher restaurantEventPublisher = new RestaurantEventPublisher(eventBus)
    CustomerRepository customerRepository = new InMemoryCustomerRepository()

    Waiter waiter = new Waiter(restaurantEventPublisher, customerRepository);

    def "get the order"() {
        given:
        Person mike = new Person("Mike Smith")
        when:
        Customer customerMike = mike.callWaiter(waiter, EggType.SUNNY_SIDE_UP)
        then:
        customerRepository.getCustomer(customerMike.getUuid())

    }
}
