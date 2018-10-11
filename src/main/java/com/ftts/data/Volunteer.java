package com.ftts.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Volunteer {

    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String email;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @OneToMany
    private List<Race> race;

    public Volunteer() {
    }

    public Volunteer(@NotNull String email, @NotNull String firstName, @NotNull String lastName, List<Race> race) {
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

    public List<Race> getRace() {
        return race;
    }

    public void setRace(List<Race> race) {
        this.race = race;
    }
}
