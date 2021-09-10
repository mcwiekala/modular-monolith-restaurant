package io.micw.eggrestaurant.restaurant;


import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

// wrapper type for person
@Value
@Slf4j
class Customer {

    UUID customerId = UUID.randomUUID();
    Visitor visitor;
    WaiterImpl waiter;

    public Customer(Visitor visitor, WaiterImpl waiter) {
        this.visitor = visitor;
        this.waiter = waiter;
    }

    void receiveMeal(Meal meal) {
        eat();
    }

    private void eat() {
        log.info("Yum... Yum...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
