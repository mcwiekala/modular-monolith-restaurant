package io.micw.eggrestaurant.cooking;

import io.micw.eggrestaurant.commons.EggType;
import lombok.Value;

import java.util.UUID;

@Value
class CookOrder {

    UUID cookOrderId = UUID.randomUUID();
    UUID customerOrderId;
    EggType eggType;

    public CookOrder(UUID customerOrderId, EggType eggType) {
        this.customerOrderId = customerOrderId;
        this.eggType = eggType;
    }
}
