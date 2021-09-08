package io.micw.eggrestaurant.restaurant;

import com.google.common.collect.Sets;
import io.micw.eggrestaurant.commons.Subscribable;

import java.util.HashSet;
import java.util.Set;

class MealEventHandler implements Subscribable<MealWasDeliveredEvent> {

    public static final Set<Class> SUPPORTED_EVENTS = Sets.newHashSet(MealWasDeliveredEvent.class);
    MealRepository mealRepository;
    Waiter waiter;

    public MealEventHandler(MealRepository mealRepository, Waiter waiter) {
        this.mealRepository = mealRepository;
        this.waiter = waiter;
    }

    @Override
    public void handle(MealWasDeliveredEvent domainEvent) {
        Meal meal = new Meal(domainEvent.getCustomerOrderId(), domainEvent.getEggType());
        mealRepository.saveMeal(meal);
        waiter.deliverMeal(meal);
    }

    @Override
    public Set<Class> supports() {
        return SUPPORTED_EVENTS;
    }


}
