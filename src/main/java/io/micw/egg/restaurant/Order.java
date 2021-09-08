package io.micw.egg.restaurant;

import io.micw.egg.commons.EggType;
import lombok.Value;

import java.util.UUID;

@Value
class Order {

    UUID uuid;
    EggType eggType;

    public Order(EggType mealWish) {
        this.uuid = UUID.randomUUID();
        this.eggType = mealWish;
    }
}
