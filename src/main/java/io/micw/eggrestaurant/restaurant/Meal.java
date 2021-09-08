package io.micw.eggrestaurant.restaurant;

import io.micw.eggrestaurant.commons.EggType;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@Value
@AllArgsConstructor
class Meal {

    UUID mealId;
    UUID customerOrderId;
    EggType eggType;

    public Meal(UUID customerOrderId, EggType eggType) {
//        TODO: id coupling?
        this.mealId = customerOrderId;
        this.customerOrderId = customerOrderId;
        this.eggType = eggType;
    }
}
