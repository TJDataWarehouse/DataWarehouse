package com.example.datawarehouse.entity.node;

import lombok.Data;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import java.io.Serializable;


@NodeEntity(label = "movie")
public class Movie{

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "movie_id")
    private String movieId;

    @Property(name = "title")
    private String movieTitle;

    @Property(name = "revenue")
    private String movieRevenue;

    @Property(name = "category")
    private String movieCategory;

    public Movie() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieRevenue() {
        return movieRevenue;
    }

    public void setMovieRevenue(String movieRevenue) {
        this.movieRevenue = movieRevenue;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieId='" + movieId + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                ", movieRevenue='" + movieRevenue + '\'' +
                ", movieCategory='" + movieCategory + '\'' +
                '}';
    }
}
