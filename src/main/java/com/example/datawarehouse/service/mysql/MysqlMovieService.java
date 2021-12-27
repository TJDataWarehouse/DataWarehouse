package com.example.datawarehouse.service.mysql;

import com.example.datawarehouse.entity.mysql.MysqlMovie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface MysqlMovieService {
    //根据asin查电影信息
    MysqlMovie findMovieByAsin(String asin);
    //根据名字查电影
    List<MysqlMovie> findMoviesByName(String movieName);
    //相关年、年月、年月日查询电影数
    int countMovieByYearAndMonthAndDay(String time);
    //最近一周的电影新增量
    int countMovieByPeriod(String time,String flag);
    //用电影名查询
    MysqlMovie findMovieByName(String name);
    //按分数查询
    List<MysqlMovie> findMoviesByScore(double score,String flag);
    //按类别查询
    List<MysqlMovie> findMovieByType(String type);
    //获取好评的电影
    List<Map<String,Object>> getGoodReviewRate(double rate);

}
