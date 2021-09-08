package io.micw.egg.cooking

import io.micw.egg.commons.EventBus
import io.micw.egg.commons.EventBusImpl
import io.micw.egg.commons.EggType
import io.micw.egg.restaurant.EggWasOrderedEvent
import spock.lang.Specification

class EggOrderHandlerTest extends Specification {

    EventBus eventBus = new EventBusImpl();
    OrderRepository orderRepository = new InMemoryOrderRepository();
    EggOrderHandler eggOrderHandler = new EggOrderHandler(orderRepository)

    def "check events"() {
        given:
        EggWasOrderedEvent event = new EggWasOrderedEvent(EggType.SCRAMBLED)
        eventBus.register(eggOrderHandler);
        when:
        eventBus.dispatch(event)
        then:
        CookOrder cookOrder = orderRepository.getOrder(event.getEventId())
        cookOrder.eggType == EggType.SCRAMBLED
    }

}
