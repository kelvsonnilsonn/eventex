package com.kelvson.eventex.controller;

import com.kelvson.eventex.command.CreateEventCommand;
import com.kelvson.eventex.command.DeleteEventCommand;
import com.kelvson.eventex.command.UpdateEventDescriptionCommand;
import com.kelvson.eventex.command.UpdateEventNameCommand;
import com.kelvson.eventex.service.command.EventCommandService;
import com.kelvson.eventex.service.query.EventQueryService;
import com.kelvson.eventex.util.AppConstants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AppConstants.EVENT_PATH)
@RequiredArgsConstructor
public class EventController {

    private final EventCommandService eventCommandService;
    private final EventQueryService eventQueryService;

    @PostMapping
    public ResponseEntity<Long> create(@Valid @RequestBody CreateEventCommand command){
        return ResponseEntity.status(HttpStatus.CREATED).body(eventCommandService.create(command));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@Valid @RequestBody DeleteEventCommand command){
        eventCommandService.delete(command);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping(AppConstants.CHANGE_EVENT_NAME)
    public ResponseEntity<Void> updateName(@Valid @RequestBody UpdateEventNameCommand command) {
        eventCommandService.update(command);
        return ResponseEntity.ok().build();
    }

    @PutMapping(AppConstants.CHANGE_DESCRIPTION_NAME)
    public ResponseEntity<Void> updateDescription(@Valid @RequestBody UpdateEventDescriptionCommand command) {
        eventCommandService.update(command);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> find(Pageable pageable, @RequestParam(required = false) Long eventId, @RequestParam(required = false) String eventName){
        if(eventId != null){
            return ResponseEntity.ok(eventQueryService.findEvent(eventId));
        }
        if(eventName != null){
            return ResponseEntity.ok(eventQueryService.findEventByName(pageable, eventName));
        }
        return ResponseEntity.ok(eventQueryService.findAll(pageable));
    }

}
