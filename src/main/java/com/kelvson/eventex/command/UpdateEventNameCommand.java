package com.kelvson.eventex.command;

public record UpdateEventNameCommand(
        Long eventId,
        String newName
) {
}
