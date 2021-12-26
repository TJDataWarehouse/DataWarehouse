package com.example.datawarehouse.controller.mysql;

import com.example.datawarehouse.entity.mysql.MysqlDirectorMovie;
import com.example.datawarehouse.service.mysql.MysqlDirectorMovieService;
import com.example.datawarehouse.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("mysql/director")
public class MysqlDirectorController {
    @Autowired
    MysqlDirectorMovieService mysqlDirectorMovieService;

    //导演的电影数
    @GetMapping("get/director/movie/number")
    public CommonResult<Map<String, Object>> getMovieNumber(@RequestParam("director_name")String director_name){
        //获取当前系统时间
        long startTime =  System.currentTimeMillis();

        List<MysqlDirectorMovie> directorMovieList = mysqlDirectorMovieService.findDirectMovie(director_name);
        int number = 0;
        if(directorMovieList != null){
            number = directorMovieList.size();
        }

        Map<String ,Object> map = new HashMap<>();
        map.put("number",number);
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
