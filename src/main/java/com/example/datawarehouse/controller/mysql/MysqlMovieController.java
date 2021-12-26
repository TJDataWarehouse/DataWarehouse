package com.example.datawarehouse.controller.mysql;

import com.example.datawarehouse.entity.mysql.MysqlMovie;
import com.example.datawarehouse.entity.mysql.MysqlReview;
import com.example.datawarehouse.service.mysql.MysqlMovieService;
import com.example.datawarehouse.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("mysql/movie")
public class MysqlMovieController {
    private static int displayMovieNumber = 4;

    @Autowired
    private MysqlMovieService mysqlMovieService;

    //查询各个时间段的电影数都是用此接口
    @GetMapping("get/movie/number")
    public CommonResult<Map<String, Object>> getMovieNumber(@RequestParam(value = "date")String date,
                                               @RequestParam(value = "flag")String flag,
                                               @RequestParam(value = "quarter",required = false)Integer quarter,
                                               @RequestParam(value = "week",required = false)Integer week){
        //获取当前系统时间
        long startTime =  System.currentTimeMillis();

        //[0]:year,[1]:month,[2]:day
        String[] timeArray = date.split("-");
        //电影数量
        int movieNumber = 0;

        if("year".equals(flag)){
            String time = timeArray[0];
            movieNumber = mysqlMovieService.countMovieByYearAndMonthAndDay(time);
        }else if("month".equals(flag)){
            String time = timeArray[0]+"-"+timeArray[1];
            movieNumber = mysqlMovieService.countMovieByYearAndMonthAndDay(time);
        }else if("day".equals(flag)){
            String time = date;
            movieNumber = mysqlMovieService.countMovieByYearAndMonthAndDay(time);
        }else if("quater".equals(flag)){
            if(quarter == null){
                return CommonResult.failed("请指定quarter");
            }
            //TODO:季度查询
//            movieNumber = mysqlMovieService.countMovieByQuarter(date,quarter);
        }else if("week".equals(flag)){
            if(week == null){
                return CommonResult.failed("请指定week");
            }
            //TODO:周查询
//            movieNumber = mysqlMovieService.countMovieByWeek(date,week);
        }else{
            return CommonResult.failed("需要提供查询粒度flag=year/month/day/quarter/week");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("number",movieNumber);
        //结束时间
        long endTime =  System.currentTimeMillis();
        double usedTime = (endTime-startTime);
        String danWei = "ms";
        if(usedTime>1000){
            usedTime = usedTime/1000;
            //保留3位小数
            usedTime = (Math.round(usedTime * 1000) / 1000.0);
            danWei = "s";
        }
        map.put("used_time",usedTime+danWei);

        return CommonResult.success(map);
    }

    //查询电影format
    @GetMapping("get/movie/format")
    public CommonResult<Map<String, Object>> getFormatNumber(@RequestParam("movie_name")String movieName){
        //获取当前系统时间
        long startTime =  System.currentTimeMillis();

        MysqlMovie mysqlMovie = mysqlMovieService.findMovieByName(movieName);
        String format = "null";
        if(mysqlMovie != null){
            format = mysqlMovie.getFormat();
        }

        Map<String,Object> map = new HashMap<>();
        map.put("format",format);
        //结束时间
        long endTime =  System.currentTimeMillis();
        double usedTime = (endTime-startTime);
        String danWei = "ms";
        if(usedTime>1000){
            usedTime = usedTime/1000;
            //保留3位小数
            usedTime = (Math.round(usedTime * 1000) / 1000.0);
            danWei = "s";
        }
        map.put("used_time",usedTime+danWei);

        return CommonResult.success(map);
    }

    //查询电影type
    @GetMapping("get/movie/type")
    public CommonResult<Map<String, Object>> getTypeNumber(@RequestParam("movie_name")String movieName){
        //获取当前系统时间
        long startTime =  System.currentTimeMillis();

        MysqlMovie mysqlMovie = mysqlMovieService.findMovieByName(movieName);
        String type = "null";
        if(mysqlMovie != null){
            type = mysqlMovie.getType();
        }

        Map<String,Object> map = new HashMap<>();
        map.put("type",type);
        //结束时间
        long endTime =  System.currentTimeMillis();
        double usedTime = (endTime-startTime);
        String danWei = "ms";
        if(usedTime>1000){
            usedTime = usedTime/1000;
            //保留3位小数
            usedTime = (Math.round(usedTime * 1000) / 1000.0);
            danWei = "s";
        }
        map.put("used_time",usedTime+danWei);

        return CommonResult.success(map);
    }

    //按评分查询电影
    @GetMapping("get/movie/by/score")
    public CommonResult<Map<String,Object>> getMovieByScore(@RequestParam("score")double score,
                                                            @RequestParam(value = "flag")String flag){
        //获取当前系统时间
        long startTime =  System.currentTimeMillis();

        //按照“>= == <=”score查电影
        List<MysqlMovie> movieList = mysqlMovieService.findMoviesByScore(score,flag);
        //返回信息
        Map<String,Object> map = new HashMap<>();
        //电影信息
        List<Map<String, Object>> movieInfoList = new ArrayList<>();

        if(movieList == null){
            map.put("number",0);
        }else{
            map.put("number",movieList.size());
            int count = displayMovieNumber;
            if(movieList.size()<displayMovieNumber){
                count = movieList.size();
            }
            for(int i =0;i < count;i++){
                Map<String,Object> m = new HashMap<>();
                m.put("movie_name",movieList.get(i).getMovieName());
                m.put("release_time",movieList.get(i).getReleaseTime());
                m.put("directors",movieList.get(i).getDirectors());
                m.put("actors",movieList.get(i).getActors());
                m.put("score",movieList.get(i).getScore());
                movieInfoList.add(m);
            }
        }
        map.put("movie",movieInfoList);

        //结束时间
        long endTime =  System.currentTimeMillis();
        double usedTime = (endTime-startTime);
        String danWei = "ms";
        if(usedTime>1000){
            usedTime = usedTime/1000;
            //保留3位小数
            usedTime = (Math.round(usedTime * 1000) / 1000.0);
            danWei = "s";
        }
        map.put("used_time",usedTime+danWei);

        return CommonResult.success(map);
    }

    //统计type
    @GetMapping("get/movie/by/type")
    public CommonResult<Map<String, Object>> getMovieByType(@RequestParam("type")String type){
        //获取当前系统时间
        long startTime =  System.currentTimeMillis();

        List<MysqlMovie> movieList = mysqlMovieService.findMovieByType(type);

        Map<String, Object> map = new HashMap<>();
        List<Map<String,Object>> movieInfoList = new ArrayList<>();
        if(movieList == null){
            map.put("number",0);
        }else{
            map.put("number",movieList.size());
            int count = displayMovieNumber;
            if(movieList.size()<displayMovieNumber){
                count = movieList.size();
            }
            for(int i =0;i < count;i++){
                Map<String,Object> m = new HashMap<>();
                m.put("movie_name",movieList.get(i).getMovieName());
                m.put("release_time",movieList.get(i).getReleaseTime());
                m.put("directors",movieList.get(i).getDirectors());
                m.put("actors",movieList.get(i).getActors());
                m.put("score",movieList.get(i).getScore());
                movieInfoList.add(m);
            }
        }
        map.put("movie",movieInfoList);

        //结束时间
        long endTime =  System.currentTimeMillis();
        double usedTime = (endTime-startTime);
        String danWei = "ms";
        if(usedTime>1000){
            usedTime = usedTime/1000;
            //保留3位小数
            usedTime = (Math.round(usedTime * 1000) / 1000.0);
            danWei = "s";
        }
        map.put("used_time",usedTime+danWei);

        return CommonResult.success(map);
    }

    //正面评价电影查询
    @GetMapping("get/good/movie")
    public CommonResult<Map<String, Object>> getGoodMovie(@RequestParam("rate")double rate){
        //获取当前系统时间
        long startTime =  System.currentTimeMillis();

        List<Map<String,Object>> movieInfoList = mysqlMovieService.getGoodReviewRate(rate);

        Map<String, Object> map = new HashMap<>();
        map.put("movie",movieInfoList);
        //结束时间
        long endTime =  System.currentTimeMillis();
        double usedTime = (endTime-startTime);
        String danWei = "ms";
        if(usedTime>1000){
            usedTime = usedTime/1000;
            //保留3位小数
            usedTime = (Math.round(usedTime * 1000) / 1000.0);
            danWei = "s";
        }
        map.put("used_time",usedTime+danWei);

        return CommonResult.success(map);
    }
}
