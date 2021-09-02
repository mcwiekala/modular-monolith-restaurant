package io.micw.commons;

import java.util.Set;

class Subscriber implements Subscribable{

    public void handle(Event<?> event) {

    }

    public Set<Class<?>> supports() {
        return null;
    }

}
