package com.kelvson.eventex.command;

public record UpdateEventDescriptionCommand(
        Long eventId,
        String newDescription
) {
}
