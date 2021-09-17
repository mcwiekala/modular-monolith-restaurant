package io.micw.eggrestaurant.wash

import io.micw.eggrestaurant.commons.EventBus
import io.micw.eggrestaurant.restaurant.DishDeliveredToSinkEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = WashConfiguration)
class MealEatenHandlerTest extends Specification {

    @Autowired
    EventBus eventBus

    @Autowired
    MealEatenHandler mealEatenHandler

    @Autowired
    DishDeliveredEventRepository dishDeliveredEventRepository

    def "test handle"() {
        UUID customerOrderId = UUID.randomUUID()
        given:
        DishDeliveredToSinkEvent deliveredToSinkEvent = new DishDeliveredToSinkEvent(customerOrderId)
        eventBus.register(mealEatenHandler)

        when:
        eventBus.dispatch(deliveredToSinkEvent)

        then:
        DishDeliveredToSinkEvent result = dishDeliveredEventRepository.getEvent(deliveredToSinkEvent.getEventId())
        result != null
        result.getCustomerOrderId() == result.getCustomerOrderId()
    }
}
