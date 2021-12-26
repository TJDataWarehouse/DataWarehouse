package com.example.datawarehouse.controller.mysql;

import com.example.datawarehouse.entity.mysql.MysqlActorMovie;
import com.example.datawarehouse.service.mysql.MysqlActorMovieService;
import com.example.datawarehouse.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("mysql/actor")
public class MysqlActorController {
    @Autowired
    MysqlActorMovieService mysqlActorMovieService;

    //参演的电影数目
    @GetMapping("get/actor/movie/number")
    public CommonResult<Integer> getMovieNumber(@RequestParam("actor_name")String actorName){
        List<MysqlActorMovie> actorMovieList = mysqlActorMovieService.findActorMovie(actorName);
        if(actorMovieList != null){
            return CommonResult.success(actorMovieList.size());
        }else{
            return CommonResult.success(0);
        }
    }



}
