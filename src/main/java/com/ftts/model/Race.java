package com.ftts.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;

@Table
@Entity
public class Race {

    @Id
    private int id;

    @Column
    @ManyToOne
    private Racer racer;

    @Column
    @NotNull
    private String raceName;

    @Column
    @NotNull
    private Time startingTime;

    @Column
    private Time finishingTime;

    @Column
    private Time finalTime;

    @Column
    private Time neutralZone;

    @Column
    private Time neutralZoneTwo;

    @Column
    private Time neutralZoneThree;

    @Column
    private int place;

    @Column
    private int points;


    public Race(int id, Racer racer, @NotNull String raceName, @NotNull Time startingTime, Time finishingTime, Time finalTime, Time neutralZone, Time neutralZoneTwo, Time neutralZoneThree, int place, int points) {
        this.id = id;
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

    public Racer getRacer() {
        return racer;
    }

    public void setRacer(Racer racer) {
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
