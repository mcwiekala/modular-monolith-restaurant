package io.micw.egg.restaurant;


import lombok.Value;

import java.util.UUID;

// wrapper type for person
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
