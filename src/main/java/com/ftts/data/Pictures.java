package com.ftts.data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

public class Pictures {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private List<Tag> tags;
    private String pictureURL;

    public Pictures() {
    }

    public Pictures(List<Tag> tags, String pictureURL) {
        this.tags = tags;

        this.pictureURL = pictureURL;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
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
