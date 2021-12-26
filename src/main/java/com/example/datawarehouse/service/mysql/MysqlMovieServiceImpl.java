package com.example.datawarehouse.service.mysql;

import com.example.datawarehouse.dao.mysql.MysqlMovieRepository;
import com.example.datawarehouse.dao.mysql.MysqlTimeInfoRepository;
import com.example.datawarehouse.entity.mysql.MysqlMovie;
import com.example.datawarehouse.entity.mysql.MysqlTimeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MysqlMovieServiceImpl implements MysqlMovieService{

    @Resource
    private MysqlMovieRepository mysqlMovieRepository;
    @Resource
    private MysqlTimeInfoRepository mysqlTimeInfoRepository;

    @Override
    public int countMovieByYearAndMonthAndDay(String yearAndMonthAndDay){
        return mysqlMovieRepository.countMysqlMovieByReleaseTimeContaining(yearAndMonthAndDay);
    }

    @Override
    public MysqlMovie findMovieByName(String name) {
        return mysqlMovieRepository.findMysqlMovieByMovieName(name);
    }

    @Override
    public List<MysqlMovie> findMoviesByScore(double score, String flag) {
        if(">".equals(flag)){
            return mysqlMovieRepository.findMysqlMoviesByScoreGreaterThan(score);
        }else if(">=".equals(flag)){
            return mysqlMovieRepository.findMysqlMoviesByScoreLessThanEqual(score);
        }else if("=".equals(flag)){
            return mysqlMovieRepository.findMysqlMoviesByScore(score);
        }else if("<".equals(flag)){
            return mysqlMovieRepository.findMysqlMoviesByScoreLessThan(score);
        }else{
            return mysqlMovieRepository.findMysqlMoviesByScoreLessThanEqual(score);
        }
    }
}
