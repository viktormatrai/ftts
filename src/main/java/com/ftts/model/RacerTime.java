package com.ftts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class RacerTime {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Racer racer;

    private LocalTime startingTime;
    private LocalTime finishingTime;
    private Long neutralZoneOne;
    private Long neutralZoneTwo;
    private Long neutralZoneThree;
    private LocalTime finalTime;

    @ManyToOne
    private Race race;

    public void calculateFinalTime(LocalTime startingTime, LocalTime finishingTime,
                                   Long neutralZoneOne,
                                   Long neutralZoneTwo,
                                   Long neutralZoneThree){

        this.startingTime = startingTime;
        Long startingTimeHour = (long) this.startingTime.getHour();
        Long startingTimeMinute = (long) this.startingTime.getMinute();
        Long startingTimeSecond = (long) this.startingTime.getSecond();

        this.finalTime= finishingTime.minusHours(startingTimeHour)
                .minusMinutes(startingTimeMinute)
                .minusSeconds(startingTimeSecond)
                .minusSeconds(neutralZoneOne)
                .minusSeconds(neutralZoneTwo)
                .minusSeconds(neutralZoneThree);
    }
}
