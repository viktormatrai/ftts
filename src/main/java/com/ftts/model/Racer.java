package com.ftts.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

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

  //  @ManyToOne
  //  private Team team;
  //  @OneToMany(mappedBy = "racer")
  //  private List<Race> race;
  //  @NotNull
  //  private Gender gender;
  //  @OneToMany(mappedBy = "racer")
  //  private List<Tag> tag;
    int points;

}
