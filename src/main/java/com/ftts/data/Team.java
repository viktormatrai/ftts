package com.ftts.data;

import javax.persistence.*;

@Table
@Entity
public class Team {

    @Id
    @GeneratedValue
    @OneToMany
    private int id;

    @Column
    private String teamName;

    @ManyToOne
    private Racer racer;

    @Column
    private int points;

    @OneToMany
    private Race race;

    public Team(int id, String teamName, Racer racer, int points, Race race) {
        this.id = id;
        this.teamName = teamName;
        this.racer = racer;
        this.points = points;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
