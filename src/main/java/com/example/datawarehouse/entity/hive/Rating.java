package com.example.datawarehouse.entity.hive;

/**
 * @author JiongJiongStrive
 * @version 1.0.0
 * @ClassName Rating.java
 * @Description TODO
 * @createTime 2021年12月26日 20:35:00
 */
public class Rating {
    private int review_count;
    private int good_review_count;

    public Rating() {
    }

    public int getReview_count() {
        return review_count;
    }

    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }

    public int getGood_review_count() {
        return good_review_count;
    }

    public void setGood_review_count(int good_review_count) {
        this.good_review_count = good_review_count;
    }
}
