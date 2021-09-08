package io.micw.egg.restaurant;


import io.micw.egg.commons.EggType;
import lombok.Value;

import java.util.UUID;

@Value
class Customer {

    UUID uuid;
    Person person;
    Waiter waiter;
    Order order;

    public Customer(Person person, Order order, Waiter waiter) {
        this.uuid = UUID.randomUUID();
        this.person = person;
        this.order = order;
        this.waiter = waiter;
    }
}
