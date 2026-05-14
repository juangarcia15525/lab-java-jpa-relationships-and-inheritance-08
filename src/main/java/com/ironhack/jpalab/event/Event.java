package com.ironhack.jpalab.event;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private LocalDate date;
    private Integer duration;
    private String location;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "event_guest",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "guest_id")
    )
    private List<Guest> guests;

    // Getters y Setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String t) { this.title = t; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate d) { this.date = d; }
    public Integer getDuration() { return duration; }
    public void setDuration(Integer d) { this.duration = d; }
    public String getLocation() { return location; }
    public void setLocation(String l) { this.location = l; }
    public List<Guest> getGuests() { return guests; }
    public void setGuests(List<Guest> g) { this.guests = g; }
}