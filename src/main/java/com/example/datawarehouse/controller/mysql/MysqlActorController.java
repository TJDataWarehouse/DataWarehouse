package com.example.datawarehouse.controller.mysql;

import com.example.datawarehouse.entity.mysql.MysqlActorActorCooperate;
import com.example.datawarehouse.entity.mysql.MysqlActorMovie;
import com.example.datawarehouse.entity.mysql.MysqlDirectorActorCooperate;
import com.example.datawarehouse.service.mysql.MysqlActorMovieService;
import com.example.datawarehouse.utils.CommonResult;
import org.apache.hadoop.tools.CopyListing;
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
    @GetMapping("get/best/partners")
    public CommonResult<Map<String,Object>> getBestPartners(@RequestParam("number")int number){
        //获取当前系统时间
        long startTime =  System.currentTimeMillis();

        //挑出来合作次数最多的
        List<MysqlActorActorCooperate> actorActorCooperateList = mysqlActorMovieService.findBestPartners(number*2);

        Map<String, Object> map = new HashMap<>();
        List<Map<String,Object>> partnerInfoList = new ArrayList<>();
        if(actorActorCooperateList != null){
            for(int i=1;i<actorActorCooperateList.size();i=i+2){
                MysqlActorActorCooperate actorActorCooperate = actorActorCooperateList.get(i);
                Map<String, Object> m = new HashMap<>();
                m.put("actor1",actorActorCooperate.getActor1());
                m.put("actor2",actorActorCooperate.getActor2());
                m.put("cooperate",actorActorCooperate.getCooperate());
                partnerInfoList.add(m);
            }
        }
        map.put("bestPartner",partnerInfoList);

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

    //查询合作最多的导演和演员
    @GetMapping("get/best/cooperations")
    public CommonResult<Map<String, Object>> getBestCooperations(@RequestParam("number")int number){
        //获取当前系统时间
        long startTime =  System.currentTimeMillis();

        //挑出来合作次数最多的
        List<MysqlDirectorActorCooperate> directorActorCooperateList = mysqlActorMovieService.findBestCooperations(number);

        Map<String, Object> map = new HashMap<>();
        List<Map<String,Object>> cooperateInfoList = new ArrayList<>();
        if(directorActorCooperateList != null){
            for(int i=0;i<directorActorCooperateList.size();i++){
                MysqlDirectorActorCooperate directorActorCooperate = directorActorCooperateList.get(i);
                Map<String, Object> m = new HashMap<>();
                m.put("director",directorActorCooperate.getDirector());
                m.put("actor",directorActorCooperate.getActor());
                m.put("cooperate",directorActorCooperate.getCooperate());
                cooperateInfoList.add(m);
            }
        }
        map.put("bestPartner",cooperateInfoList);

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
