package io.micw.eggrestaurant.restaurant

import io.micw.eggrestaurant.commons.EggType
import io.micw.eggrestaurant.commons.EventBus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = RestaurantConfiguration.class)
class MealEventHandlerTest extends Specification {

    public static final EggType eggType = EggType.SCRAMBLED

    @Autowired
    EventBus eventBus

    @Autowired
    MealRepository mealRepository

    @Autowired
    OrderRepository orderRepository

    @Autowired
    MealEventHandler mealEventHandler

    @Autowired
    CustomerRepository customerRepository

    Waiter waiter = Mock(Waiter.class)
    Customer customer = Mock(Customer.class)

    def "check events"() {
        given:
        waiter.deliverMeal(_) >> true
        customer.getIsInLocal() >> true

        customerRepository.saveCustomer(customer)
        Order order = new Order(customer.customerId, eggType)
        orderRepository.saveOrder(order)
        MealWasDeliveredEvent event = new MealWasDeliveredEvent(order.getOrderId(), eggType)
        eventBus.register(mealEventHandler)
        when:
        eventBus.dispatch(event)
        then:
        Meal meal = mealRepository.getMeal(order.mealId)
        meal != null
    }

}
