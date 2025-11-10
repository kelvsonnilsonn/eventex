package com.kelvson.eventex.command;

import com.kelvson.eventex.util.AppConstants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DeleteEventCommand(
        @NotNull(message = "O ID do evento" + AppConstants.NOT_NULL_MESSAGE) Long eventId,
        @Size(max = 80, message = "A razão pode ter, no máximo, até 80 caracteres") String reason
) {
}
