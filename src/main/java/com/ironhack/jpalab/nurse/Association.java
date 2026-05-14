package com.ironhack.jpalab.nurse;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "association_id")
    private List<Division> divisions;

    // Getters y Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String n) { this.name = n; }
    public List<Division> getDivisions() { return divisions; }
    public void setDivisions(List<Division> d) { this.divisions = d; }
}