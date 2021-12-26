package com.example.datawarehouse.controller.mysql;

import com.example.datawarehouse.entity.mysql.MysqlDirectorMovie;
import com.example.datawarehouse.service.mysql.MysqlDirectorMovieService;
import com.example.datawarehouse.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("mysql/director")
public class MysqlDirectorController {
    @Autowired
    MysqlDirectorMovieService mysqlDirectorMovieService;

    @GetMapping("get/director/movie/number")
    public CommonResult<Integer> getMovieNumber(@RequestParam("director_name")String director_name){
        List<MysqlDirectorMovie> directorMovieList = mysqlDirectorMovieService.findDirectMovie(director_name);
        if(directorMovieList != null){
            return CommonResult.success(directorMovieList.size());
        }else{
            return CommonResult.success(0);
        }
    }

}
