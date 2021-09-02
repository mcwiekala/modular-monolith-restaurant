package io.micw.commons;

import java.util.Set;

interface Subscribable {

    void handle(Event<?> event);
    Set<Class<?>> supports();
}
