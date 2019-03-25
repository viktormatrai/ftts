package com.ftts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToMany(mappedBy = "tags", cascade = CascadeType.MERGE)
    private List<Racer> racers;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "tags_races",
            joinColumns = @JoinColumn(name = "race_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Race> races;

    @OneToMany(mappedBy = "tag")
    private List<Picture> pictures;

   }
