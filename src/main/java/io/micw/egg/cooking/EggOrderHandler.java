package io.micw.egg.cooking;

import com.google.common.collect.Sets;
import io.micw.egg.commons.Subscribable;
import io.micw.egg.restaurant.EggWasOrderedEvent;

import java.util.HashSet;
import java.util.Set;

class EggOrderHandler implements Subscribable<EggWasOrderedEvent> {

    public static final HashSet<Class<?>> SUPPORTED_EVENTS = Sets.newHashSet(EggWasOrderedEvent.class);
    OrderRepository orderRepository;

    public EggOrderHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void handle(EggWasOrderedEvent domainEvent) {
        orderRepository.saveOrder(new CookOrder(domainEvent.getEventId(), domainEvent.getEggType()));
        System.out.println("We get the order!");
        System.out.println("Now we can cook!");
    }

    @Override
    public Set<Class<?>> supports() {
        return SUPPORTED_EVENTS;
    }
}
