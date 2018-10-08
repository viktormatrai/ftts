package com.ftts.data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class ChampionshipStandings {

    @ManyToOne
    private List<Racer> racer;
    @ManyToOne
    private List<Race> race;
    @ManyToOne
    private List<Team> team;
    private int individualPoints;
    private int teamPoints;
    private int individualPlaceInStandings;
    private int teamPlaceInStandings;

    public ChampionshipStandings(List<Racer> racer, List<Race> race, List<Team> team, int individualPoints, int teamPoints, int individualPlaceInStandings, int teamPlaceInStandings) {
        this.racer = racer;
        this.race = race;
        this.team = team;
        this.individualPoints = individualPoints;
        this.teamPoints = teamPoints;
        this.individualPlaceInStandings = individualPlaceInStandings;
        this.teamPlaceInStandings = teamPlaceInStandings;
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

    public List<Team> getTeam() {
        return team;
    }

    public void setTeam(List<Team> team) {
        this.team = team;
    }

    public int getIndividualPoints() {
        return individualPoints;
    }

    public void setIndividualPoints(int individualPoints) {
        this.individualPoints = individualPoints;
    }

    public int getTeamPoints() {
        return teamPoints;
    }

    public void setTeamPoints(int teamPoints) {
        this.teamPoints = teamPoints;
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
