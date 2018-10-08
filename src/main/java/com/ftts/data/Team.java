package com.ftts.data;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class Team {

    @Id
    @GeneratedValue
    @OneToMany
    private int id;
    private String teamName;
    @ManyToOne
    private List<Racer> racer;
    private int points;
    @OneToMany
    private Race race;

    public Team(String teamName, List<Racer> racer, int points, Race race) {
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

    public List<Racer> getRacer() {
        return racer;
    }

    public void setRacer(List<Racer> racer) {
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
