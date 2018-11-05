package com.ftts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Tag {

    @Id
    @GeneratedValue
    private Long Id;
    private String tag;

    @ManyToOne
  //  @JoinColumns(@JoinColumn( name = "racer_name", referencedColumnName = "nameOfRacer"))
    private Racer racer;

    @ManyToOne
    private Race race;
    @OneToMany(mappedBy = "tags")
    private List<Pictures> pictures;

   }
