package io.micw.eggrestaurant.restaurant;

import io.micw.eggrestaurant.commons.EggType;

import java.util.UUID;

interface Waiter {

    Order receiveWishFromPerson(Visitor visitor, EggType eggType);

    boolean deliverMeal(Meal meal);

}
