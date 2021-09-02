package io.micw.commons;

class MessageEvent implements DomainEvent<String> {

    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    @Override
    public String getData() {
        return message;
    }
}
