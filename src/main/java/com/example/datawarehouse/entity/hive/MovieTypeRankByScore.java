package com.example.datawarehouse.entity.hive;

/**
 * @author JiongJiongStrive
 * @version 1.0.0
 * @ClassName MovieTypeRankByScore.java
 * @Description TODO
 * @createTime 2021年12月26日 21:29:00
 */
public class MovieTypeRankByScore {
    private String type;
    private double score;

    public MovieTypeRankByScore() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
