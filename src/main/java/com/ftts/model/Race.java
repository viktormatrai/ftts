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

    @ManyToOne
    @JoinColumn(name = "racerId")
    private Racer racer;

    // @ManyToOne
    // private Volunteer volunteer;
    // @OneToMany(mappedBy = "race")
    //   private List<Tag> tag;


}
