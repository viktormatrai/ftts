package com.ftts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Pictures {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne(targetEntity = Pictures.class)
    private Tag tags;
    private String pictureURL;

}
