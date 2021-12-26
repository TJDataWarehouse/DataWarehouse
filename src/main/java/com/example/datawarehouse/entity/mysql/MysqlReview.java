package com.example.datawarehouse.entity.mysql;

import javax.persistence.*;

@Entity
@Table(name = "review", schema = "data_warehouse", catalog = "")
public class MysqlReview {
    private int id;
    private String reviewerId;
    private String profileName;
    private int helpfulness;
    private double score;
    private String time;
    private String summary;
    private String text;
    private String asin;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "reviewer_id")
    public String getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(String reviewerId) {
        this.reviewerId = reviewerId;
    }

    @Basic
    @Column(name = "profileName")
    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    @Basic
    @Column(name = "helpfulness")
    public int getHelpfulness() {
        return helpfulness;
    }

    public void setHelpfulness(int helpfulness) {
        this.helpfulness = helpfulness;
    }

    @Basic
    @Column(name = "score")
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "asin")
    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MysqlReview that = (MysqlReview) o;

        if (id != that.id) return false;
        if (helpfulness != that.helpfulness) return false;
        if (Double.compare(that.score, score) != 0) return false;
        if (reviewerId != null ? !reviewerId.equals(that.reviewerId) : that.reviewerId != null) return false;
        if (profileName != null ? !profileName.equals(that.profileName) : that.profileName != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (summary != null ? !summary.equals(that.summary) : that.summary != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (asin != null ? !asin.equals(that.asin) : that.asin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (reviewerId != null ? reviewerId.hashCode() : 0);
        result = 31 * result + (profileName != null ? profileName.hashCode() : 0);
        result = 31 * result + helpfulness;
        temp = Double.doubleToLongBits(score);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (asin != null ? asin.hashCode() : 0);
        return result;
    }
}
