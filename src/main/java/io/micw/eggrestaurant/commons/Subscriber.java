package io.micw.eggrestaurant.commons;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class Subscriber implements Subscribable{

    public static final HashSet<Class<?>> SUPPORTED_EVENTS = Sets.newHashSet(MessageEvent.class);

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void handle(DomainEvent domainEvent) {
      log.info("#######################################");
      log.info(name + " received an event!");
//      log.info("Message: " + domainEvent.getData());
      log.info("#######################################");
    }

    @Override
    public Set<Class<?>> supports() {
        return SUPPORTED_EVENTS;
    }

}
