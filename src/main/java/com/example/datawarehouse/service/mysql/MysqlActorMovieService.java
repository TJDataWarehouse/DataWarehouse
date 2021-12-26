package com.example.datawarehouse.service.mysql;

import com.example.datawarehouse.entity.mysql.MysqlActorMovie;

import java.util.List;

public interface MysqlActorMovieService {
    //演的电影
    List<MysqlActorMovie> findActorMovie(String actorName);
}
