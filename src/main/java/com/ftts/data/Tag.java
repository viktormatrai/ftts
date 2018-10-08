package com.ftts.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Tag {

    @Id
    @GeneratedValue
    @ManyToMany
    private int Id;
    private String tag;
    @ManyToOne
    private List<Racer> racer;
    @ManyToOne
    private List<Race> raceName;

    public Tag(String tag, List<Racer> racer, List<Race> raceName) {
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

    public List<Racer> getRacer() {
        return racer;
    }

    public void setRacer(List<Racer> racer) {
        this.racer = racer;
    }

    public List<Race> getRaceName() {
        return raceName;
    }

    public void setRaceName(List<Race> raceName) {
        this.raceName = raceName;
    }
}
