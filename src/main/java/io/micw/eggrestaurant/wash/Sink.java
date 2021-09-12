package io.micw.eggrestaurant.wash;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
class Sink {

    List<DirtyDishes> dishes = new ArrayList<>();

}
