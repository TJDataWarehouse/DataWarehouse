package com.example.datawarehouse.entity.mysql;

import javax.persistence.*;

@Entity
@Table(name = "time_info", schema = "data_warehouse", catalog = "")
public class MysqlTimeInfo {
    private String id;
    private int year;
    private int quarter;
    private int month;
    private int week;
    private int day;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Basic
    @Column(name = "quarter")
    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    @Basic
    @Column(name = "month")
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Basic
    @Column(name = "week")
    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    @Basic
    @Column(name = "day")
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MysqlTimeInfo that = (MysqlTimeInfo) o;

        if (year != that.year) return false;
        if (quarter != that.quarter) return false;
        if (month != that.month) return false;
        if (week != that.week) return false;
        if (day != that.day) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + year;
        result = 31 * result + quarter;
        result = 31 * result + month;
        result = 31 * result + week;
        result = 31 * result + day;
        return result;
    }
}
