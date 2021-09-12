package io.micw.eggrestaurant.restaurant;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

// wrapper type for person
@Data
@Slf4j
class Customer {

    private UUID customerId = UUID.randomUUID();
    private UUID orderId;
    private Visitor visitor;
    private Waiter waiter;
    private Boolean isInLocal;
    private Boolean isFoodDelivered;
//    CustomerEventPublisher customerEventPublisher;

    public Customer(Visitor visitor, Waiter waiter) {
        this.visitor = visitor;
        this.waiter = waiter;
//        this.customerEventPublisher = customerEventPublisher;
        this.isInLocal = true;
        this.isFoodDelivered = false;
    }

    void receiveMeal(Meal meal) {
        isFoodDelivered = true;
        eat(meal);
        goAway();
    }

    private void goAway() {
        log.info(visitor.getName() + ": Bye!");
        isInLocal = false;
    }

    private void eat(Meal meal) {
        log.info(visitor.getName() + " is eating: " + meal.getEggType());
        log.info(visitor.getName() + ": Yum... Yum...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Error", e);
        }
    }
}
