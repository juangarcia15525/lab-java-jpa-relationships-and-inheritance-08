package com.ironhack.jpalab.nurse;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String district;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "president_id")
    private Member president;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "division_id")
    private List<Member> members;

    // Getters y Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String n) { this.name = n; }
    public String getDistrict() { return district; }
    public void setDistrict(String d) { this.district = d; }
    public Member getPresident() { return president; }
    public void setPresident(Member m) { this.president = m; }
    public List<Member> getMembers() { return members; }
    public void setMembers(List<Member> m) { this.members = m; }
}