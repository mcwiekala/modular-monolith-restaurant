package io.micw.egg.restaurant;

import io.micw.egg.commons.EggType;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@Value
@AllArgsConstructor
class Meal {

    UUID orderId;
    EggType eggType;

}
