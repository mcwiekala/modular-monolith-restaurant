package io.micw.eggrestaurant.commons;

import java.util.Set;

public interface Subscribable<T extends DomainEvent> {

    void handle(T domainEvent);

    Set<Class> supports();
}
