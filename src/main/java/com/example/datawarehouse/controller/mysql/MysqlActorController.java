package com.example.datawarehouse.controller.mysql;

import com.example.datawarehouse.entity.mysql.MysqlActorMovie;
import com.example.datawarehouse.service.mysql.MysqlActorMovieService;
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
@RequestMapping("mysql/actor")
public class MysqlActorController {
    @Autowired
    MysqlActorMovieService mysqlActorMovieService;

    //参演的电影数目
    @GetMapping("get/actor/movie/number")
    public CommonResult<Map<String, Object>> getMovieNumber(@RequestParam("actor_name")String actorName){
        //获取当前系统时间
        long startTime =  System.currentTimeMillis();

        List<MysqlActorMovie> actorMovieList = mysqlActorMovieService.findActorMovie(actorName);
        int number = 0;
        if(actorMovieList != null){
            number = actorMovieList.size();
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

    //查询合作最多的演员搭档
//    @GetMapping("get/best/partners")
//    public CommonResult<Map<String,Object>> getBestPartners(){
//
//    }

}
