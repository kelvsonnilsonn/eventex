package com.kelvson.eventex.command;

import com.kelvson.eventex.util.AppConstants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateEventNameCommand(
        @NotNull(message = "O ID do evento" + AppConstants.NOT_NULL_MESSAGE) Long eventId,
        @Size(max = 100, message = "A razão pode ter, no máximo, até 100 caracteres") String newName
) {
}
