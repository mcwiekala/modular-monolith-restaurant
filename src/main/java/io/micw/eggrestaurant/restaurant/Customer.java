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
    Boolean isInLocal;
    CustomerEventPublisher customerEventPublisher;

    public Customer(Visitor visitor, WaiterImpl waiter, CustomerEventPublisher customerEventPublisher) {
        this.visitor = visitor;
        this.waiter = waiter;
        this.customerEventPublisher = customerEventPublisher;
        this.isInLocal = true;
    }

    void receiveMeal(Meal meal) {
        eat(meal);
    }

    private void eat(Meal meal) {
        log.info(visitor.getName() + " is eating: " + meal.getEggType());
        log.info("Yum... Yum...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Error", e);
        }
    }
}
