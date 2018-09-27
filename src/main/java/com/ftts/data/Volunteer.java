package com.ftts.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Volunteer {

    @Id
    @GeneratedValue
    private int id;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String firstName;

    @Column
    @NotNull
    private String lastName;

    @Column
    @ManyToOne
    private Race race;

    public Volunteer(int id, @NotNull String email, @NotNull String firstName, @NotNull String lastName, Race race) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.race = race;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
