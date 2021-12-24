package com.example.datawarehouse.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="movie")
public class MysqlMovie {
    @Id
    @Column(name = "asin")
    private String asin;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "release_time")
    private String releaseTime;

    @Column(name = "rating")
    private String rating;

    @Column(name = "format")
    private String format;

    @Column(name = "actors")
    private String actors;

    @Column(name = "directors")
    private String directors;

    @Column(name = "score")
    private double score;

    @Column(name = "type")
    private String type;

}
