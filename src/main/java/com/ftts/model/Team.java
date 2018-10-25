package com.ftts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Team {

    @Id
    @GeneratedValue
    private Long id;
    private String teamName;
    //@OneToMany(mappedBy = "team")
    //private List<Racer> racer;
   // @OneToMany
   // private List<Race> race;
    int teamPoints;

}
