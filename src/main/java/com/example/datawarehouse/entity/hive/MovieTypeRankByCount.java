package com.example.datawarehouse.entity.hive;

/**
 * @author JiongJiongStrive
 * @version 1.0.0
 * @ClassName MovieTypeRankByCount.java
 * @Description TODO
 * @createTime 2021年12月26日 21:27:00
 */
public class MovieTypeRankByCount {
    private String movie_name;
    private long movie_count;

    public MovieTypeRankByCount() {
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public long getMovie_count() {
        return movie_count;
    }

    public void setMovie_count(int movie_count) {
        this.movie_count = movie_count;
    }
}
