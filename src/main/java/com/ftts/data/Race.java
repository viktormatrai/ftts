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
    @ManyToOne(targetEntity = Racer.class)
    private Racer racer;
    @ManyToOne(targetEntity = Volunteer.class)
    private Volunteer volunteer;
    @OneToMany(mappedBy = "raceName")
    private List<Tag> tag;

    @NotNull
    private String raceName;

    @NotNull
    private Time startingTime;
    private Time finishingTime;
    private Time finalTime;
    private Time neutralZone;
    private Time neutralZoneTwo;
    private Time neutralZoneThree;

    public Race() {
    }

    public Race(Racer racer, @NotNull String raceName, @NotNull Time startingTime, Time finishingTime, Time finalTime, Time neutralZone, Time neutralZoneTwo, Time neutralZoneThree) {
        this.racer = racer;
        this.raceName = raceName;
        this.startingTime = startingTime;
        this.finishingTime = finishingTime;
        this.finalTime = finalTime;
        this.neutralZone = neutralZone;
        this.neutralZoneTwo = neutralZoneTwo;
        this.neutralZoneThree = neutralZoneThree;
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

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }
}
