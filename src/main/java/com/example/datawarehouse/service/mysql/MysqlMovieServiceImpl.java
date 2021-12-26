package com.example.datawarehouse.service.mysql;

import com.example.datawarehouse.dao.mysql.MysqlMovieRepository;
import com.example.datawarehouse.dao.mysql.MysqlReviewRepository;
import com.example.datawarehouse.dao.mysql.MysqlTimeInfoRepository;
import com.example.datawarehouse.entity.mysql.MysqlMovie;
import com.example.datawarehouse.entity.mysql.MysqlReview;
import com.example.datawarehouse.entity.mysql.MysqlTimeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MysqlMovieServiceImpl implements MysqlMovieService{

    @Resource
    private MysqlMovieRepository mysqlMovieRepository;
    @Resource
    private MysqlReviewRepository mysqlReviewRepository;

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
            return mysqlMovieRepository.findMysqlMoviesByScoreGreaterThanEqual(score);
        }else if("=".equals(flag)){
            return mysqlMovieRepository.findMysqlMoviesByScore(score);
        }else if("<".equals(flag)){
            return mysqlMovieRepository.findMysqlMoviesByScoreLessThan(score);
        }else{
            return mysqlMovieRepository.findMysqlMoviesByScoreLessThanEqual(score);
        }
    }

    @Override
    public List<MysqlMovie> findMovieByType(String type) {
        return mysqlMovieRepository.findMysqlMoviesByTypeContaining(type);
    }

    @Override
    public List<Map<String, Object>> getGoodReviewRate(double rate) {
        List<Map<String, Object>> map = new ArrayList<>();

        //所有电影
        List<MysqlMovie> movieList = mysqlMovieRepository.findAll();
        for(MysqlMovie movie : movieList){
            //找对应的评论
            List<MysqlReview> reviewList = mysqlReviewRepository.findMysqlReviewsByAsin(movie.getAsin());
            //找好评数量和好评率
            double goodNumber = 0;
            double goodRate = 0;
            if(reviewList != null){
                for(MysqlReview review : reviewList){
                    if(review.getScore()>=4){
                        goodNumber++;
                    }
                }
                goodRate = goodNumber/reviewList.size();
            }
            if(goodRate >= rate){
                Map<String, Object> m = new HashMap<>();
                m.put("rate",goodRate);
                m.put("movie_name",movie.getMovieName());
                m.put("release_time",movie.getReleaseTime());
                m.put("directors",movie.getDirectors());
                m.put("actors",movie.getActors());
                m.put("score",movie.getScore());
                map.add(m);
            }
        }

        return map;
    }
}
