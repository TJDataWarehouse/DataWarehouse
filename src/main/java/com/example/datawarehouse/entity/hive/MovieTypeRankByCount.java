package com.example.datawarehouse.entity.hive;

/**
 * @author JiongJiongStrive
 * @version 1.0.0
 * @ClassName MovieTypeRankByCount.java
 * @Description TODO
 * @createTime 2021年12月26日 21:27:00
 */
public class MovieTypeRankByCount {
    private String type;
    private long movie_count;

    public MovieTypeRankByCount() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getMovie_count() {
        return movie_count;
    }

    public void setMovie_count(long movie_count) {
        this.movie_count = movie_count;
    }
}
