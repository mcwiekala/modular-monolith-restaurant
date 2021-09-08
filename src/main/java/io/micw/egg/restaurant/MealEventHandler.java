package io.micw.egg.restaurant;

import com.google.common.collect.Sets;
import io.micw.egg.commons.Subscribable;

import java.util.HashSet;
import java.util.Set;

class MealEventHandler implements Subscribable<MealWasDeliveredEvent> {

    public static final HashSet<Class<?>> SUPPORTED_EVENTS = Sets.newHashSet(MealWasDeliveredEvent.class);
    MealRepository mealRepository;

    public MealEventHandler(MealRepository orderRepository) {
        this.mealRepository = orderRepository;
    }

    @Override
    public void handle(MealWasDeliveredEvent domainEvent) {
        Meal meal = new Meal(domainEvent.getEventId(), domainEvent.getEggType());
        mealRepository.saveMeal(meal);

    }

    @Override
    public Set<Class<?>> supports() {
        return SUPPORTED_EVENTS;
    }


}
