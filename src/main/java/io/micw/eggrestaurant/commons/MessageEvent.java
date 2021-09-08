package io.micw.eggrestaurant.commons;

import java.util.UUID;

class MessageEvent implements DomainEvent {

    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    @Override
    public UUID getEventId() {
        return null;
    }

    public String getMessage() {
        return message;
    }
}
