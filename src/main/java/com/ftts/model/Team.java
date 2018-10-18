package com.ftts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Team {

    @Id
    @GeneratedValue
    private int id;
    private String teamName;
   // @OneToMany(mappedBy = "team")
   // private List<Racer> racer;
   // private int points;
   // @OneToMany
   // private List<Race> race;
    int teamPoints;
}
