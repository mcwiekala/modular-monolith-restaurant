package io.micw.egg.cooking;

import com.google.common.collect.Sets;
import io.micw.egg.commons.Subscribable;
import io.micw.egg.restaurant.EggWasOrderedEvent;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
class EggOrderHandler implements Subscribable<EggWasOrderedEvent> {

    public static final HashSet<Class<?>> SUPPORTED_EVENTS = Sets.newHashSet(EggWasOrderedEvent.class);
    OrderRepository orderRepository;
    Cook cook;

    public EggOrderHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void handle(EggWasOrderedEvent domainEvent) {
        orderRepository.saveOrder(new CookOrder(domainEvent.getEventId(), domainEvent.getEggType()));
        log.info("We get the order!");
        log.info("Now we can cook!");
        cook.makeMeal(domainEvent.getEggType());
        log.info("done!");
    }

    @Override
    public Set<Class<?>> supports() {
        return SUPPORTED_EVENTS;
    }
}
