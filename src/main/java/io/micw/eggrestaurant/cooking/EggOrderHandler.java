package io.micw.eggrestaurant.cooking;

import com.google.common.collect.Sets;
import io.micw.eggrestaurant.commons.Subscribable;
import io.micw.eggrestaurant.restaurant.EggWasOrderedEvent;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
@Value
class EggOrderHandler implements Subscribable<EggWasOrderedEvent> {

    Set<Class> SUPPORTED_EVENTS = Sets.newHashSet(EggWasOrderedEvent.class);
    CookOrderRepository cookOrderRepository;
    Cook cook;

    public EggOrderHandler(CookOrderRepository cookOrderRepository, Cook cook) {
        this.cookOrderRepository = cookOrderRepository;
        this.cook = cook;
    }

    @Override
    public void handle(EggWasOrderedEvent domainEvent) {
        cookOrderRepository.saveOrder(new CookOrder(domainEvent.getCustomerOrderId(), domainEvent.getEggType()));
        log.info("We get the order!");
        log.info("Now we can cook!");
        cook.makeMeal(domainEvent.getCustomerOrderId(), domainEvent.getEggType());
        log.info("done!");
    }

    @Override
    public Set<Class> supports() {
        return SUPPORTED_EVENTS;
    }
}
