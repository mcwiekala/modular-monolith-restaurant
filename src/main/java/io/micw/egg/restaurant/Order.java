package io.micw.egg.restaurant;

import io.micw.egg.commons.EggType;

import java.util.UUID;

class Order {

    UUID uuid;
    EggType eggType;

    public Order(EggType eggType) {
        this.uuid = UUID.randomUUID();
        this.eggType = eggType;
    }
}
