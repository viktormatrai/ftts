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
public class Race {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String raceName;
    private LocalTime startingTime;
    private LocalTime finishingTime;
    private Long neutralZoneOne;
    private Long neutralZoneTwo;
    private Long neutralZoneThree;
    private LocalTime finalTime;

 //   private Racer racer;

 //   @ManyToOne(targetEntity = Volunteer.class)
 //   private Volunteer volunteer;
 //   @OneToMany(mappedBy = "raceName")
 //   private List<Tag> tag;


}
