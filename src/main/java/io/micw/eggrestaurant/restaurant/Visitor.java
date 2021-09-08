package io.micw.eggrestaurant.restaurant;


import io.micw.eggrestaurant.commons.EggType;
import lombok.AllArgsConstructor;
import lombok.Value;

// He might be a client or not. When he make a order, he became a client.
@Value
@AllArgsConstructor
class Visitor {

    String name;

    Order callWaiter(Waiter waiter, EggType mealWish){
        return waiter.receiveWishFromPerson(this, mealWish);
    }

}
