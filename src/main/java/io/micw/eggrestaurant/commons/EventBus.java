package io.micw.eggrestaurant.commons;

import java.util.List;

public interface EventBus {

    void register(Subscribable subscribable);
    void unregister(Subscribable subscribable);
    void dispatch(DomainEvent domainEvent);
    List<Subscribable> getSubscribers();

}
