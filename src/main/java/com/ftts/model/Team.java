package com.ftts.model;

import javax.persistence.*;

@Table
@Entity
public class Team {

    @Id
    private int id;

    @OneToMany
    private String teamName;

    @ManyToOne
    private Racer racer;

    @OneToMany
    private Race race;

    public Team(int id, String teamName, Racer racer, Race race) {
        this.id = id;
        this.teamName = teamName;
        this.racer = racer;
        this.race = race;
    }

    public int getId() {
        return id;
    }

    public String getTeamName() {

        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Racer getRacer() {
        return racer;
    }

    public void setRacer(Racer racer) {
        this.racer = racer;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
