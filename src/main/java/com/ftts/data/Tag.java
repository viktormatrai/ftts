package com.ftts.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Tag {

    @Id
    @GeneratedValue
    private int Id;
    private String tag;
    @ManyToOne
    private Racer racer;
    @ManyToOne
    private Race raceName;

    public Tag() {
    }

    public Tag(String tag, Racer racer, Race raceName) {
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
