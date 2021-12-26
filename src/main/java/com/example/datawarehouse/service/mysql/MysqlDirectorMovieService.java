package com.example.datawarehouse.service.mysql;

import com.example.datawarehouse.entity.mysql.MysqlDirectorMovie;

import java.util.List;

public interface MysqlDirectorMovieService {
    List<MysqlDirectorMovie> getDirectMovie(String directorName);
}
