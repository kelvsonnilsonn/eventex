package com.kelvson.eventex.command;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kelvson.eventex.util.AppConstants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record CreateEventCommand(
        @NotNull(message = "O nome do evento" + AppConstants.NOT_NULL_MESSAGE) String eventName,
        @NotNull(message = "A descrição do evento" + AppConstants.NOT_NULL_MESSAGE)
        @Size(max = 200, message = "A descrição pode ter, no máximo, até 200 caracteres")
        String description,
        @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss")
        LocalDateTime date
) {
}
