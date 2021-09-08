package io.micw.egg.restaurant;


import io.micw.egg.commons.EventBus;
import io.micw.egg.commons.EventBusImpl;
import io.micw.egg.commons.EggType;

class Customer {

    EventBus eventBus;

    public Customer() {
        this.eventBus = new EventBusImpl();
    }

    void orderEgg(EggType eggType) {
        EggWasOrderedEvent eggWasOrderedEvent = new EggWasOrderedEvent(eggType);
        eventBus.dispatch(eggWasOrderedEvent);
    }

}
