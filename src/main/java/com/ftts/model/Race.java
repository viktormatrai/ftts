package com.ftts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(mappedBy = "race")
    private List<RacerTime> racerTimes;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "racer_race",
            joinColumns = { @JoinColumn(name = "racer_id") },
            inverseJoinColumns = { @JoinColumn(name = "race_id")}
    )
    private List<Racer> racers;

    @ManyToMany(mappedBy = "races", cascade = CascadeType.MERGE)
    @ToString.Exclude
    private List<Volunteer> volunteers;

    @ManyToMany(mappedBy = "races", cascade = CascadeType.MERGE)
    private List<Tag> tag;



    public void setStartingTimeForRacer(LocalTime startingTime){
        this.racerTimes.stream().forEach(racerTime -> racerTime.setStartingTime(startingTime));
    }

    public void setFinishingTimeForRacer(LocalTime finishingTime){
        this.racerTimes.stream().forEach(racerTime -> racerTime.setFinishingTime(finishingTime));
    }

    public void setNeutralZoneOneForRacer(Long neutralZoneOne){
        this.racerTimes.stream().forEach(racerTime -> racerTime.setNeutralZoneOne(neutralZoneOne));
    }

    public void setNeutralZoneTwoForRacer(Long neutralZoneTwo){
        this.racerTimes.stream().forEach(racerTime -> racerTime.setNeutralZoneTwo(neutralZoneTwo));
    }

    public void setNeutralZoneThreeForRacer(Long neutralZoneThree){
        this.racerTimes.stream().forEach(racerTime -> racerTime.setNeutralZoneThree(neutralZoneThree));
    }

}
