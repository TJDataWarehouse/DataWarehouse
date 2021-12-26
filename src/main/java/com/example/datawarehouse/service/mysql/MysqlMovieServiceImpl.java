package com.example.datawarehouse.service.mysql;

import com.example.datawarehouse.dao.mysql.MysqlMovieRepository;
import com.example.datawarehouse.dao.mysql.MysqlTimeInfoRepository;
import com.example.datawarehouse.entity.mysql.MysqlMovie;
import com.example.datawarehouse.entity.mysql.MysqlTimeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MysqlMovieServiceImpl implements MysqlMovieService{

    @Autowired
    private MysqlMovieRepository mysqlMovieRepository;
    @Autowired
    private MysqlTimeInfoRepository mysqlTimeInfoRepository;

    @Override
    public int countMovieByYearAndMonthAndDay(String yearAndMonthAndDay){
        return mysqlMovieRepository.countMysqlMovieByReleaseTimeContaining(yearAndMonthAndDay);
    }
}
