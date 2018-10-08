package com.ftts.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.List;

@Entity
public class Race {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private List<Racer> racer;
    @NotNull
    private String raceName;
    @NotNull
    private Time startingTime;
    private Time finishingTime;
    private Time finalTime;
    private Time neutralZone;
    private Time neutralZoneTwo;
    private Time neutralZoneThree;
    private int place;
    private int points;


    public Race(List<Racer> racer, @NotNull String raceName, @NotNull Time startingTime, Time finishingTime, Time finalTime, Time neutralZone, Time neutralZoneTwo, Time neutralZoneThree, int place, int points) {
        this.racer = racer;
        this.raceName = raceName;
        this.startingTime = startingTime;
        this.finishingTime = finishingTime;
        this.finalTime = finalTime;
        this.neutralZone = neutralZone;
        this.neutralZoneTwo = neutralZoneTwo;
        this.neutralZoneThree = neutralZoneThree;
        this.place = place;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public List<Racer> getRacer() {
        return racer;
    }

    public void setRacer(List<Racer> racer) {
        this.racer = racer;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public Time getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Time startingTime) {
        this.startingTime = startingTime;
    }

    public Time getFinishingTime() {
        return finishingTime;
    }

    public void setFinishingTime(Time finishingTime) {
        this.finishingTime = finishingTime;
    }

    public Time getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(Time finalTime) {
        this.finalTime = finalTime;
    }

    public Time getNeutralZone() {
        return neutralZone;
    }

    public void setNeutralZone(Time neutralZone) {
        this.neutralZone = neutralZone;
    }

    public Time getNeutralZoneTwo() {
        return neutralZoneTwo;
    }

    public void setNeutralZoneTwo(Time neutralZoneTwo) {
        this.neutralZoneTwo = neutralZoneTwo;
    }

    public Time getNeutralZoneThree() {
        return neutralZoneThree;
    }

    public void setNeutralZoneThree(Time neutralZoneThree) {
        this.neutralZoneThree = neutralZoneThree;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
