package com.example.datawarehouse.controller.mysql;

import com.example.datawarehouse.entity.mysql.MysqlMovie;
import com.example.datawarehouse.service.mysql.MysqlMovieService;
import com.example.datawarehouse.utils.CommonResult;
import org.apache.commons.cli.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mysql/test")
public class TestController {
    @Autowired
    MysqlMovieService mysqlMovieService;

//    @GetMapping("get/movie")
//    public CommonResult<Object> getMovie(@RequestParam("asin")String asin){
//        MysqlMovie movie =
//    }
}
