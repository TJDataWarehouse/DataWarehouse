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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MysqlMovieServiceImpl implements MysqlMovieService{

    @Resource
    private MysqlMovieRepository mysqlMovieRepository;
    @Resource
    private MysqlReviewRepository mysqlReviewRepository;

    @Override
    public MysqlMovie findMovieByAsin(String asin) {
        return mysqlMovieRepository.findMysqlMovieByAsin(asin);
    }

    @Override
    public List<MysqlMovie> findMoviesByName(String movieName) {
        return mysqlMovieRepository.findMysqlMoviesByMovieNameContaining(movieName);
    }

    //辅助函数，用于将字符串转为日历
    private Calendar stringToCalendar(String time){
        //将字符串转为date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = dateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //用date生成日历对象
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    @Override
    public int countMovieByYearAndMonthAndDay(String yearAndMonthAndDay){
        return mysqlMovieRepository.countMysqlMovieByReleaseTimeContaining(yearAndMonthAndDay);
    }

    @Override
    public int countMovieByPeriod(String time,String flag) {
        int number= 0;
        //找到当天的日历
        Calendar calendar = stringToCalendar(time);
        String[] timeArray = time.split("-");
        int month = Integer.parseInt(timeArray[1]);
        int season = (month-1) / 3 + 1;
        int finalMonth = season*3;
        int startMonth = finalMonth - 2;
        System.out.println(calendar.getTime());
        if("quarter".equals(flag)){
            calendar.add(Calendar.MONTH,startMonth-month);
        }else{
            calendar.add(Calendar.DAY_OF_YEAR,-7);
        }
        //现在
        String after = time;
        if("quarter".equals(flag)){
            String temp = finalMonth+"";
            if(month<10) {
                after = timeArray[0] + '0' +temp + timeArray[2];
            }else{
                after =  timeArray[0] + temp + timeArray[2];
            }
        }
        //过去
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String before = simpleDateFormat.format(date);
        //开始查询
        List<MysqlMovie> movieList = mysqlMovieRepository.findMysqlMoviesByReleaseTimeBetween(before,after);
        if(movieList!=null){
            number = movieList.size();
        }
        return number;
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
