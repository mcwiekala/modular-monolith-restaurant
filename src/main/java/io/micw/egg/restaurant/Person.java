package io.micw.egg.restaurant;


import io.micw.egg.commons.EggType;
import lombok.AllArgsConstructor;
import lombok.Value;

// He might be a client or not. When he make a order, he became a client.
@Value
@AllArgsConstructor
class Person {

    String name;

    Customer callWaiter(Waiter waiter, EggType mealWish){
        return waiter.createOrder(this, mealWish);
    }

}
