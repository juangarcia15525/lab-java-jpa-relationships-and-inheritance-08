package com.ironhack.jpalab.event;

import jakarta.persistence.*;

@Entity
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer presentationDuration;

    // Getters y Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String n) { this.name = n; }
    public Integer getPresentationDuration() { return presentationDuration; }
    public void setPresentationDuration(Integer d) { this.presentationDuration = d; }
}