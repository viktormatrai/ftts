package com.ftts.data;

import javax.persistence.*;
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
    @OneToMany(mappedBy = "tags")
    private List<Pictures> pictures;

    public Tag() {
    }

    public Tag(String tag, Racer racer, Race raceName, List<Pictures> pictures) {
        this.tag = tag;
        this.racer = racer;
        this.raceName = raceName;
        this.pictures = pictures;
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

    public List<Pictures> getPictures() {
        return pictures;
    }

    public void setPictures(List<Pictures> pictures) {
        this.pictures = pictures;
    }
}
