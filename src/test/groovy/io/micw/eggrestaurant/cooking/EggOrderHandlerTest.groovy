package io.micw.eggrestaurant.cooking

import io.micw.eggrestaurant.commons.EventBus
import io.micw.eggrestaurant.commons.EventBusImpl
import io.micw.eggrestaurant.commons.EggType
import io.micw.eggrestaurant.restaurant.EggWasOrderedEvent
import spock.lang.Specification

class EggOrderHandlerTest extends Specification {

    EventBus eventBus = new EventBusImpl();

    CookOrderRepository cookOrderRepository = new InMemoryCookOrderRepository();
    CookingEventPublisher cookingEventPublisher = new CookingEventPublisher(eventBus)
    Cook cook = new Cook(cookingEventPublisher)

    EggOrderHandler eggOrderHandler = new EggOrderHandler(cookOrderRepository, cook)

    def "check events"() {
        given:
        UUID customerOrderId = UUID.randomUUID();
        EggWasOrderedEvent event = new EggWasOrderedEvent(customerOrderId, EggType.SCRAMBLED)
        eventBus.register(eggOrderHandler);
        when:
        eventBus.dispatch(event)
        then:
        CookOrder cookOrder = cookOrderRepository.getOrder(customerOrderId)
        cookOrder.eggType == EggType.SCRAMBLED
    }

}
