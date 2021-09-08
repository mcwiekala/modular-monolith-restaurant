package io.micw.eggrestaurant.cooking;

import io.micw.eggrestaurant.commons.EggType;
import lombok.Value;

import java.util.UUID;

@Value
class CookOrder {

    UUID cookOrderId;
    UUID clientOrderId;
    EggType eggType;

    public CookOrder(UUID clientOrderId, EggType eggType) {
//        TODO: id coupling?!
        this.cookOrderId = clientOrderId;
        this.clientOrderId = clientOrderId;
        this.eggType = eggType;
    }
}
