package com.example.datawarehouse.entity.hive;

/**
 * @author JiongJiongStrive
 * @version 1.0.0
 * @ClassName MovieRankByGoodReivew.java
 * @Description TODO
 * @createTime 2021年12月26日 21:35:00
 */
public class MovieRankByGoodReivew {
    private String asin;
    private long review_good_count;

    public MovieRankByGoodReivew() {
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public long getReview_good_count() {
        return review_good_count;
    }

    public void setReview_good_count(long review_good_count) {
        this.review_good_count = review_good_count;
    }
}
