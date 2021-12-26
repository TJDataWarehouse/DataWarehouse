package com.example.datawarehouse.service.mysql;

import com.example.datawarehouse.entity.mysql.MysqlMovie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface MysqlMovieService {
    //相关年、年月、年月日查询
    int countMovieByYearAndMonthAndDay(String time);
    //用电影名查询
    MysqlMovie findMovieByName(String name);
    //按分数查询
    List<MysqlMovie> findMoviesByScore(double score,String flag);
    //按类别查询
    List<MysqlMovie> findMovieByType(String type);
    //获取好评的电影
    List<Map<String,Object>> getGoodReviewRate(double rate);
}
