package com.ftts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Volunteer {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String email;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;

    @NonNull
    private String nameOfVolunteer;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "volunteer_race",
                joinColumns = @JoinColumn(name = "volunteer_id"),
                inverseJoinColumns = @JoinColumn(name = "race_id"))
    private List<Race> races;

    public List<String> getRaceNameList(){
        return this.races.stream().map(race -> race.getRaceName()).collect(Collectors.toList());
    }

 }
