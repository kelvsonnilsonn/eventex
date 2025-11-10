package com.kelvson.eventex.dto;

import java.time.LocalDateTime;

public record EventResponseDTO(
        Long eventId,
        String eventName,
        String eventDescription,
        LocalDateTime date
) {
}
