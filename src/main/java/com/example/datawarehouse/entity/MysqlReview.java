package com.example.datawarehouse.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="review")
public class MysqlReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "reviewer_id")
    private String reviewerId;

    @Column(name = "profileName")
    private String profileName;

    @Column(name = "helpfulness")
    private int helpfulness;

    @Column(name = "score")
    private double score;

    @Column(name = "time")
    private String time;

    @Column(name = "summary")
    private String summary;

    @Column(name = "text")
    private String text;

    @Column(name = "asin")
    private String asin;
}
