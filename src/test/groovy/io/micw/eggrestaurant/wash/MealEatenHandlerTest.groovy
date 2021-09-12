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

    def "test handle"() {
        UUID customerOrderId = UUID.randomUUID()
        given:
        DishDeliveredToSinkEvent deliveredToSinkEvent = new DishDeliveredToSinkEvent(customerOrderId)

        when:
        eventBus.dispatch(deliveredToSinkEvent)
        then:
        true
    }
}
