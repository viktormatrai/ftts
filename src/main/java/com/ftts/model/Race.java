package com.ftts.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Race {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String raceName;

    private LocalDate dateOfRace;
    private LocalTime startingTime;
    private LocalTime finishingTime;
    private Long neutralZoneOne;
    private Long neutralZoneTwo;
    private Long neutralZoneThree;
    private LocalTime finalTime;

    @ManyToMany(mappedBy = "races", cascade = CascadeType.MERGE)
    private List<Racer> racers;

    @ManyToMany(mappedBy = "races", cascade = CascadeType.MERGE)
    private List<Volunteer> volunteers;

    @ManyToMany(mappedBy = "races", cascade = CascadeType.MERGE)
    private List<Tag> tag;

    public void calculateFinalTime(LocalTime startingTime, LocalTime finishingTime,
                                   Long neutralZoneOne,
                                   Long neutralZoneTwo,
                                   Long neutralZoneThree){

        this.startingTime = startingTime;
        Long startingTimeHour = Long.valueOf(this.startingTime.getHour());
        Long startingTimeMinute = Long.valueOf(this.startingTime.getMinute());
        Long startingTimeSecond = Long.valueOf(this.startingTime.getSecond());

        this.finalTime= finishingTime.minusHours(startingTimeHour)
                                    .minusMinutes(startingTimeMinute)
                                    .minusSeconds(startingTimeSecond)
                                    .minusSeconds(neutralZoneOne)
                                    .minusSeconds(neutralZoneTwo)
                                    .minusSeconds(neutralZoneThree);
    }

    public void setStartingTimeForRacer(LocalTime startingTime){
        this.racers.stream().forEach(racer -> setStartingTime(startingTime));
    }

    public void setFinishingTimeForRacer(LocalTime finishingTime){
        this.racers.stream().forEach(racer -> setFinishingTime(finishingTime));
    }

    public void setNeutralZoneOneForRacer(Long neutralZoneOne){
        this.racers.stream().forEach(racer -> setNeutralZoneOne(neutralZoneOne));
    }

    public void setNeutralZoneTwoForRacer(Long neutralZoneTwo){
        this.racers.stream().forEach(racer -> setNeutralZoneTwo(neutralZoneTwo));
    }

    public void setNeutralZoneThreeForRacer(Long neutralZoneThree){
        this.racers.stream().forEach(racer -> setNeutralZoneThree(neutralZoneThree));
    }

}
