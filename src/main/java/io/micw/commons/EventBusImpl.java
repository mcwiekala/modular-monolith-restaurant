package io.micw.commons;

import java.util.List;
import java.util.Map;

class EventBusImpl implements EventBus {

    Map<Event, Subscribable> map;

    public void register(Subscribable subscribable) {

    }

    public void dispatch(Event<?> event) {

    }

    public List<Subscribable> getSubscribers() {
        return null;
    }
}
