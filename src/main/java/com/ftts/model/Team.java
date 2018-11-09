package com.ftts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Team {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String teamName;

    @JsonIgnore
    @OneToMany(mappedBy = "team")
    private List<Racer> racers;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "team_race",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "race_id")
            )
    private List<Race> races;

    int teamPoints;


    public void calculateTeamPoints(List<Racer> racers){

        int sum = racers.stream()
                .mapToInt(Racer::getPoints)
                .sum();

        this.teamPoints = sum;
    }

    public List<String> getRaceNameList(){
        return this.races.stream().map(racer -> racer.getRaceName()).collect(Collectors.toList());
    }

    public List<String> getRacersInTeam(){
        return this.racers.stream().map(racer -> racer.getNameOfRacer()).collect(Collectors.toList());
    }
}
