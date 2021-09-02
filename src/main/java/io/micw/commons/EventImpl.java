package io.micw.commons;

class EventImpl implements Event<String> {

    private String message;

    public EventImpl(String message) {
        this.message = message;
    }

    public String getData() {
        return message;
    }
}
