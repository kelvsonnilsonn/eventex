package com.kelvson.eventex.command;

public record DeleteEventCommand(
        Long eventId,
        String reason
) {
}
