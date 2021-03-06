package com.ftts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

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
    @JsonProperty("id")
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    private String nickName;

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

    public List<String> getRaceNameList(){
        return this.races.stream().map(Race::getRaceName).collect(Collectors.toList());
    }



}
