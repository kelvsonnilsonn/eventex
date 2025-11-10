package com.kelvson.eventex.service.command;

import com.kelvson.eventex.command.CreateEventCommand;
import com.kelvson.eventex.command.DeleteEventCommand;
import com.kelvson.eventex.command.UpdateEventDescriptionCommand;
import com.kelvson.eventex.command.UpdateEventNameCommand;
import com.kelvson.eventex.exception.EventNotFoundException;
import com.kelvson.eventex.mapper.EventMapper;
import com.kelvson.eventex.model.Event;
import com.kelvson.eventex.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EventCommandService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public Long create(CreateEventCommand command){
        Event newEvent = eventRepository.save(eventMapper.toEntity(command));
        return newEvent.getId();
    }

    public void delete(DeleteEventCommand command){
        eventRepository.deleteById(command.eventId());
    }

    public void update(UpdateEventNameCommand command){
        Event event = findEntity(command.eventId());
        event.setEventName(command.newName());
        eventRepository.save(event);
    }

    public void update(UpdateEventDescriptionCommand command){
        Event event = findEntity(command.eventId());
        event.setEventDescription(command.newDescription());
        eventRepository.save(event);
    }

    private Event findEntity(Long id){
        return eventRepository.findById(id).orElseThrow(EventNotFoundException::new);
    }
}
