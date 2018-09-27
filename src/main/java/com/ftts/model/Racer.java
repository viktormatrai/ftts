package com.ftts.model;

import javax.persistence.*;

@Table
@Entity
public class Racer {

    @Id
    @OneToMany
    private int id;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String firstName;
    @Column
    private String lastname;
    @Column
    private Team team;
    @Column
    @ManyToOne
    private Race race;

    @Column
    private Gender gender;

    @Column
    private Tag tag;
    public Racer(int id, String email, String password, String firstName, String lastname, Team team, Race race, Gender gender, Tag tag) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
        this.team = team;
        this.race = race;
        this.gender = gender;
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
