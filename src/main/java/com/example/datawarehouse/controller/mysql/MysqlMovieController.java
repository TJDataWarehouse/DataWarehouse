package com.example.datawarehouse.controller.mysql;

import com.example.datawarehouse.service.mysql.MysqlMovieService;
import com.example.datawarehouse.service.mysql.MysqlMovieServiceImpl;
import com.example.datawarehouse.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mysql/movie")
public class MysqlMovieController {

    private MysqlMovieService mysqlMovieService = new MysqlMovieServiceImpl();

    //查询各个时间段的电影数都是用此接口
    @GetMapping("get/movie/number")
    public CommonResult<Object> getMovieNumber(@RequestParam(value = "date")String date,
                                               @RequestParam(value = "flag")String flag,
                                               @RequestParam(value = "quarter",required = false)Integer quarter,
                                               @RequestParam(value = "week",required = false)Integer week){
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

        return CommonResult.success(movieNumber);
    }
}
