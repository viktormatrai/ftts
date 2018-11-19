package com.ftts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Racer {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String nameOfRacer;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "racer_race",
            joinColumns = { @JoinColumn(name = "racer_id") },
            inverseJoinColumns = { @JoinColumn(name = "race_id")}
    )
    private List<Race> races;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "racers_teams",
            joinColumns = {@JoinColumn(name = "racer_id")},
            inverseJoinColumns = {@JoinColumn(name = "team_id")}
    )
    private Team team;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            joinColumns = @JoinColumn(name = "racer_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    int points;

    public void addRace(Race race){
        races.add(race);
        race.setRacers((List<Racer>) this);
    }

    public List<String> getRaceNameList(){
        return this.races.stream().map(race -> race.getRaceName()).collect(Collectors.toList());
    }


}
