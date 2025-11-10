package com.kelvson.eventex.command;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record CreateEventCommand(
        String eventName,
        String description,
        @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss")
        LocalDateTime date
) {
}
