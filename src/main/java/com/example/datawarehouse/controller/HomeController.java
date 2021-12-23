package com.example.datawarehouse.controller;

import com.example.datawarehouse.entity.Movie;
import com.example.datawarehouse.service.mysql.MovieService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class HomeController {

    @Resource
    MovieService movieService;

    @RequestMapping("/movie")
    public List<Movie> getAllMovie() {
        return movieService.getAllMovie();
    }
}
