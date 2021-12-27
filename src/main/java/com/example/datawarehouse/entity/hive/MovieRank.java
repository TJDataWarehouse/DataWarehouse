package com.example.datawarehouse.entity.hive;

/**
 * @author JiongJiongStrive
 * @version 1.0.0
 * @ClassName MovieRank.java
 * @Description TODO
 * @createTime 2021年12月26日 20:52:00
 */
public class MovieRank {
    private String movie_name;
    private String value;

    public MovieRank() {
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
