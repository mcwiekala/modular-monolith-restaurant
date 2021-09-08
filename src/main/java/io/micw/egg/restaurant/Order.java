package io.micw.egg.restaurant;

import io.micw.egg.commons.EggType;
import lombok.Value;

import java.util.UUID;

@Value
class Order {

    UUID uuid;
    Customer customer;
    EggType eggType;

    public Order(Customer customer, EggType eggType) {
        this.uuid = UUID.randomUUID();
        this.customer = customer;
        this.eggType = eggType;
    }
}
