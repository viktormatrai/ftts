package com.ftts.data;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class Team {

    @Id
    @GeneratedValue
    private int id;
    private String teamName;
    @OneToMany(mappedBy = "team")
    private List<Racer> racer;
    private int points;
    @OneToMany
    private List<Race> race;
    int teamPoints;

    public Team() {
    }

    public Team(String teamName, List<Racer> racer, int points, List<Race> race, int teamPoints) {
        this.teamName = teamName;
        this.racer = racer;
        this.points = points;
        this.race = race;
        this.teamPoints = teamPoints;
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

    public List<Race> getRace() {
        return race;
    }

    public void setRace(List<Race> race) {
        this.race = race;
    }

    public int getTeamPoints() {
        return teamPoints;
    }

    public void setTeamPoints(int teamPoints) {
        this.teamPoints = teamPoints;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
