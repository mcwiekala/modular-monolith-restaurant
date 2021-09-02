package io.micw.people;

import lombok.Value;

import java.time.LocalDate;

@Value
class Person {

    private String name;
    private String address;

    Letter writeLetter(String message, Person recipient) {
        return Letter.builder()
                .author(name)
                .date(LocalDate.now())
                .destinationAddress(recipient.address)
                .recipient(recipient.name)
                .message(message)
                .build();
    }

}
