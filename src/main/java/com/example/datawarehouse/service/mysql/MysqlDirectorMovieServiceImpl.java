package com.example.datawarehouse.service.mysql;

import com.example.datawarehouse.dao.mysql.MysqlDirectorMovieRepository;
import com.example.datawarehouse.entity.mysql.MysqlDirectorMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MysqlDirectorMovieServiceImpl implements MysqlDirectorMovieService{
    @Autowired
    MysqlDirectorMovieRepository mysqlDirectorMovieRepository;

    @Override
    public List<MysqlDirectorMovie> getDirectMovie(String directorName) {
        return mysqlDirectorMovieRepository.findMysqlDirectorMoviesByName(directorName);
    }
}
