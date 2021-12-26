package com.example.datawarehouse.service.mysql;

import com.example.datawarehouse.entity.mysql.MysqlMovie;
import org.springframework.stereotype.Service;

@Service
public interface MysqlMovieService {
    //相关年、年月、年月日查询
    int countMovieByYearAndMonthAndDay(String time);
    //用电影名查询
    MysqlMovie findMovieByName(String name);
}
