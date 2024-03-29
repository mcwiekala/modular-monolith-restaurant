package io.micw.eggrestaurant.restaurant;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class InMemoryMealRepository implements MealRepository {

    Map<UUID, Meal> map = new HashMap();

    @Override
    public void saveMeal(Meal meal) {
        map.put(meal.getMealId(), meal);
    }

    @Override
    public Meal getMeal(UUID orderId) {
        return map.get(orderId);
    }
}