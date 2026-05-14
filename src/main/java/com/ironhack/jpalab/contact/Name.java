package com.ironhack.jpalab.contact;

import jakarta.persistence.Embeddable;

@Embeddable
public class Name {

    private String salutation;
    private String firstName;
    private String middleName;
    private String lastName;

    // Getters y Setters
    public String getSalutation() { return salutation; }
    public void setSalutation(String s) { this.salutation = s; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String s) { this.firstName = s; }
    public String getMiddleName() { return middleName; }
    public void setMiddleName(String s) { this.middleName = s; }
    public String getLastName() { return lastName; }
    public void setLastName(String s) { this.lastName = s; }
}