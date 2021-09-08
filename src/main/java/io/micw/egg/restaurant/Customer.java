package io.micw.egg.restaurant;


import io.micw.egg.commons.EggType;

class Customer {

    RestaurantEventPublisher restaurantEventPublisher;

    public Customer(RestaurantEventPublisher restaurantEventPublisher) {
        this.restaurantEventPublisher = restaurantEventPublisher;
    }

    void orderEgg(EggType eggType) {
        EggWasOrderedEvent eggWasOrderedEvent = new EggWasOrderedEvent(eggType);
        restaurantEventPublisher.publish(eggWasOrderedEvent);
    }

}
