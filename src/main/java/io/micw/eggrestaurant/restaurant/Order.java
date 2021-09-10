package io.micw.eggrestaurant.restaurant;

import io.micw.eggrestaurant.commons.EggType;
import lombok.Data;
import lombok.Value;

import java.util.UUID;

@Data
class Order {

    private UUID uuid = UUID.randomUUID();
    private UUID mealId;
    private UUID customerId;
    private EggType eggType;

    public Order(UUID mealId, UUID customerId, EggType eggType) {
        this.mealId = mealId;
        this.customerId = customerId;
        this.eggType = eggType;
    }

    public Order(UUID customerId, EggType eggType) {
        this.customerId = customerId;
        this.eggType = eggType;
    }
}
