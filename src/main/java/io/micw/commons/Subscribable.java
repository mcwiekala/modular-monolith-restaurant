package io.micw.commons;

import java.util.Set;

interface Subscribable {

    void handle(DomainEvent<?> domainEvent);

    Set<Class<?>> supports();
}
