package com.example.datawarehouse.service.mysql;

public interface MysqlMovieService {
    //相关年、年月、年月日查询
    int countMovieByYearAndMonthAndDay(String time);
}
