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
    @NotNull
    private String email;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @NonNull
    private String nameOfVolunteer;
   // @OneToMany(mappedBy = "volunteer")
   // private List<Race> race;

 }
