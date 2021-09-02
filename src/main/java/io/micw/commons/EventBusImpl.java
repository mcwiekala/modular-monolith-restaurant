package io.micw.commons;

import java.util.ArrayList;
import java.util.List;

class EventBusImpl implements EventBus {

    private List<Subscribable> subscribers = new ArrayList<>();

    @Override
    public void register(Subscribable subscribable) {
        subscribers.add(subscribable);
    }

    @Override
    public void unregister(Subscribable subscribable) {
        subscribers.remove(subscribable);
    }

    @Override
    public void dispatch(DomainEvent<?> domainEvent) {
        subscribers.stream()
                .filter(s -> s.supports().contains(domainEvent.getClass()))
                .forEach(s -> s.handle(domainEvent));
    }

    @Override
    public List<Subscribable> getSubscribers() {
        return new ArrayList<>(subscribers);
    }
}
