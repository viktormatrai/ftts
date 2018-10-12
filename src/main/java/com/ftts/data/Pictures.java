package com.ftts.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Pictures {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne(targetEntity = Pictures.class)
    private Tag tags;
    private String pictureURL;

    public Pictures() {
    }

    public Pictures(Tag tags, String pictureURL) {
        this.tags = tags;

        this.pictureURL = pictureURL;
    }

    public Tag getTags() {
        return tags;
    }

    public void setTags(Tag tags) {
        this.tags = tags;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public int getId() {
        return id;
    }
}
