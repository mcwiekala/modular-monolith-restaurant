package io.micw.commons;

import java.util.List;

interface EventBus {

    void register(Subscribable subscribable);
    void dispatch(DomainEvent<?> domainEvent);
    List<Subscribable> getSubscribers();

}
