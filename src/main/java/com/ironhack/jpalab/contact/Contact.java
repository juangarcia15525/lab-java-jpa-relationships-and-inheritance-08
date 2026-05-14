package com.ironhack.jpalab.contact;

import jakarta.persistence.*;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;
    private String title;

    @Embedded
    private Name name;

    // Getters y Setters
    public Long getId() { return id; }
    public String getCompany() { return company; }
    public void setCompany(String s) { this.company = s; }
    public String getTitle() { return title; }
    public void setTitle(String s) { this.title = s; }
    public Name getName() { return name; }
    public void setName(Name n) { this.name = n; }
}