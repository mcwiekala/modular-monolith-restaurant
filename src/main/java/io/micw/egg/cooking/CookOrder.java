package io.micw.egg.cooking;

import io.micw.egg.commons.EggType;
import lombok.Value;

import java.util.UUID;

@Value
class CookOrder {

    UUID orderId;
    EggType eggType;
}
