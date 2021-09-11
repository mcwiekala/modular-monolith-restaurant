package io.micw.eggrestaurant.cooking

import io.micw.eggrestaurant.commons.EggType
import io.micw.eggrestaurant.commons.EventBus
import io.micw.eggrestaurant.restaurant.EggWasOrderedEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = CookingConfiguration.class)
class EggOrderHandlerTest extends Specification {

    @Autowired
    EventBus eventBus;

    @Autowired
    CookOrderRepository cookOrderRepository

    @Autowired
    CookingEventPublisher cookingEventPublisher

    @Autowired
    Cook cook

    @Autowired
    EggOrderHandler eggOrderHandler

    def "check events"() {
        given:
        UUID customerOrderId = UUID.randomUUID();
        EggWasOrderedEvent event = new EggWasOrderedEvent(customerOrderId, EggType.SCRAMBLED)
        eventBus.register(eggOrderHandler);
        when:
        eventBus.dispatch(event)
        then:
        CookOrder cookOrder = cookOrderRepository.map.values().stream().filter({ cookOrder -> cookOrder.getCustomerOrderId() == customerOrderId }).findAny().orElseThrow()
        cookOrder.customerOrderId == customerOrderId
        cookOrder.eggType == EggType.SCRAMBLED
    }

}
