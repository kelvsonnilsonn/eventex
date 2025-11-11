package com.kelvson.eventex.service.query;

import com.kelvson.eventex.dto.EventResponseDTO;
import com.kelvson.eventex.dto.PageResponseDTO;
import com.kelvson.eventex.exception.EventNotFoundException;
import com.kelvson.eventex.mapper.EventMapper;
import com.kelvson.eventex.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EventQueryService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public EventResponseDTO findEvent(Long id){
        return eventMapper.toResponse(eventRepository.findById(id).orElseThrow(EventNotFoundException::new));
    }

    public PageResponseDTO<EventResponseDTO> findEventByName(Pageable pageable, String eventName){
        Page<EventResponseDTO> events = eventRepository.findByEventName(pageable, eventName).map(eventMapper::toResponse);
        return PageResponseDTO.fromPage(events);
    }

    public PageResponseDTO<EventResponseDTO> findAll(Pageable pageable){
        Page<EventResponseDTO> events = eventRepository.findAll(pageable).map(eventMapper::toResponse);
        return PageResponseDTO.fromPage(events);
    }

}
