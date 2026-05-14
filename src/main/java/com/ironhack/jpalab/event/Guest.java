package com.ironhack.jpalab.event;

import jakarta.persistence.*;

@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private GuestStatus status;

    // Getters y Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String n) { this.name = n; }
    public GuestStatus getStatus() { return status; }
    public void setStatus(GuestStatus s) { this.status = s; }
}