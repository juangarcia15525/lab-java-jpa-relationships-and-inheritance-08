package com.ironhack.jpalab.nurse;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    private LocalDate renewalDate;

    // Getters y Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String n) { this.name = n; }
    public MemberStatus getStatus() { return status; }
    public void setStatus(MemberStatus s) { this.status = s; }
    public LocalDate getRenewalDate() { return renewalDate; }
    public void setRenewalDate(LocalDate d) { this.renewalDate = d; }
}