package com.ftts.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ChampionshipStandings {


    @Column
    private Racer racer;

    @Column
    private Race race;

    @Column
    private Team team;

    @Column
    private int individualPlaceInStandings;

    @Column
    private int teamPlaceInStandings;

    public ChampionshipStandings(Racer racer, Race race, Team team, int individualPlaceInStandings, int teamPlaceInStandings) {
        this.racer = racer;
        this.race = race;
        this.team = team;
        this.individualPlaceInStandings = individualPlaceInStandings;
        this.teamPlaceInStandings = teamPlaceInStandings;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getIndividualPlaceInStandings() {
        return individualPlaceInStandings;
    }

    public void setIndividualPlaceInStandings(int individualPlaceInStandings) {
        this.individualPlaceInStandings = individualPlaceInStandings;
    }

    public int getTeamPlaceInStandings() {
        return teamPlaceInStandings;
    }

    public void setTeamPlaceInStandings(int teamPlaceInStandings) {
        this.teamPlaceInStandings = teamPlaceInStandings;
    }
}
