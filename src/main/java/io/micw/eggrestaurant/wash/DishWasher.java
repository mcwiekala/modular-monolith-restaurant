package io.micw.eggrestaurant.wash;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
class DishWasher {

    Sink sink;

    public void addDishesToSink(DirtyDishes dishes) {
        sink.getDishes().add(dishes);
    }

    @Scheduled(fixedRate = 25000L)
    public void cleanDishes() {
        List<DirtyDishes> dirtyDishes = sink.getDishes();
        if (dirtyDishes.isEmpty()) {
            return;
        }
        log.info("Cleaning the dishes!");
        log.info("bulb... bulb...");
        List<CleanDishes> cleanDishes = dirtyDishes.stream().map(dishes -> new CleanDishes()).collect(Collectors.toList());
    }

    public void putDishesIntoCupboard(CleanDishes dishes) {
        log.info("Dishes are on table!");
    }
}
