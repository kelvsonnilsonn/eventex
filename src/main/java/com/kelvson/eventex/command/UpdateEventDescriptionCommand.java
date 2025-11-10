package com.kelvson.eventex.command;

import com.kelvson.eventex.util.AppConstants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateEventDescriptionCommand(
        @NotNull(message = "O ID do evento" + AppConstants.NOT_NULL_MESSAGE) Long eventId,
        @Size(max = 200, message = "A razão pode ter, no máximo, até 200 caracteres") String newDescription
) {
}
