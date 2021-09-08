package io.micw.egg.restaurant;

import java.util.UUID;

interface MealRepository {

    void saveMeal(Meal meal);
    Meal getMeal(UUID mealId);
}