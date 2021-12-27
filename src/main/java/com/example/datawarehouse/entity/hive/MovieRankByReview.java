package com.example.datawarehouse.entity.hive;

/**
 * @author JiongJiongStrive
 * @version 1.0.0
 * @ClassName MovieRankByReview.java
 * @Description TODO
 * @createTime 2021年12月26日 21:30:00
 */
public class MovieRankByReview {
    private String asin;
    private long review_count;

    public MovieRankByReview() {
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public long getReview_count() {
        return review_count;
    }

    public void setReview_count(long review_count) {
        this.review_count = review_count;
    }
}
