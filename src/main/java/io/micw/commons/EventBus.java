package io.micw.commons;

import java.util.List;

interface EventBus {

    void register(Subscribable subscribable);
    void dispatch(Event<?> event);
    List<Subscribable> getSubscribers();

}
