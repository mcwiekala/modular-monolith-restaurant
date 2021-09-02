package io.micw.people;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Builder
@Value
class Letter {

    private String author;
    private String recipient;
    private String destinationAddress;
    private LocalDate date;
    private String message;

}
