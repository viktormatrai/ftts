package com.ftts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Picture {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "tag")
    private Tag tag;
    private String pictureURL;

}
