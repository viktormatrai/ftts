package com.ftts.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table
@Entity
public class Tag {

    @Id
    @ManyToMany
    private int Id;

    @Column
    private String tag;

    @Column
    @ManyToOne
    private Racer racer;

    @Column
    @ManyToOne
    private Race raceName;

    public Tag(int id, @NotNull String tag, Racer racer, Race raceName) {
        Id = id;
        this.tag = tag;
        this.racer = racer;
        this.raceName = raceName;
    }


    public int getId() {
        return Id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Racer getRacer() {
        return racer;
    }

    public void setRacer(Racer racer) {
        this.racer = racer;
    }

    public Race getRaceName() {
        return raceName;
    }

    public void setRaceName(Race raceName) {
        this.raceName = raceName;
    }
}
