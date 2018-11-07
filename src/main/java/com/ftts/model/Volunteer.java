package com.ftts.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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
   // @OneToMany(mappedBy = "volunteer")
   // private List<Race> race;

 }
