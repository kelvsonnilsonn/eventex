package com.kelvson.eventex.mapper;

import com.kelvson.eventex.command.CreateEventCommand;
import com.kelvson.eventex.dto.EventResponseDTO;
import com.kelvson.eventex.model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventMapper {

    Event toEntity(CreateEventCommand dto);

    @Mapping(target = "eventId", source = "id")
    EventResponseDTO toResponse(Event event);

}
