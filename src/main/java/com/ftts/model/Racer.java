package com.ftts.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Racer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

   // @OneToMany(mappedBy = "racer")
   // private List<Race> race;
    @ManyToOne
    private Team team;
    //
    @NonNull
    private Gender gender;
  //  @OneToMany(mappedBy = "racer")
  //  private List<Tag> tag;
    int points;

}
