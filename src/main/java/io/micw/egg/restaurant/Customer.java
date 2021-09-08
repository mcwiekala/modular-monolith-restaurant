package io.micw.egg.restaurant;


import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

// wrapper type for person
@Value
@Slf4j
class Customer {

    UUID uuid;
    Visitor visitor;
    Waiter waiter;

    public Customer(Visitor visitor, Waiter waiter) {
        this.uuid = UUID.randomUUID();
        this.visitor = visitor;
        this.waiter = waiter;
    }

    void receiveMeal(Meal meal) {
        eat();
    }

    private void eat() {
        log.info("Yum... Yum...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
