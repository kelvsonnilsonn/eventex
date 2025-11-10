package com.kelvson.eventex.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventName;
    private String eventDescription;
    private LocalDateTime date;

    public Event(String eventName, String eventDescription, LocalDateTime date){
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.date = date;
    }
}
