package com.example.datawarehouse.service.mysql;

import com.example.datawarehouse.dao.mysql.MysqlMovieRepository;
import com.example.datawarehouse.entity.Movie;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MovieService {

    @Resource
    MysqlMovieRepository mysqlMovieRepository;

    public List<Movie> getAllMovie() {
        return mysqlMovieRepository.findAll();
    }
}
