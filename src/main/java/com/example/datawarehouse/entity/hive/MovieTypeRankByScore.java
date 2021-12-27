package com.example.datawarehouse.entity.hive;

/**
 * @author JiongJiongStrive
 * @version 1.0.0
 * @ClassName MovieTypeRankByScore.java
 * @Description TODO
 * @createTime 2021年12月26日 21:29:00
 */
public class MovieTypeRankByScore {
    private String movie_name;
    private double score;

    public MovieTypeRankByScore() {
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
