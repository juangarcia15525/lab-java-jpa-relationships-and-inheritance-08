package com.ironhack.jpalab.event;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Conference extends Event {

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "conference_speaker",
            joinColumns = @JoinColumn(name = "conference_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id")
    )
    private List<Speaker> speakers;

    public List<Speaker> getSpeakers() { return speakers; }
    public void setSpeakers(List<Speaker> s) { this.speakers = s; }
}