package com.example.datawarehouse.service.mysql;

import com.example.datawarehouse.entity.mysql.MysqlActorActorCooperate;
import com.example.datawarehouse.entity.mysql.MysqlActorMovie;
import com.example.datawarehouse.entity.mysql.MysqlDirectorActorCooperate;

import java.util.List;

public interface MysqlActorMovieService {
    //演的电影
    List<MysqlActorMovie> findActorMovie(String actorName);
    //合作最多的演员
    List<MysqlActorActorCooperate> findBestPartners(int number);
    //合作最多的导演和演员
    List<MysqlDirectorActorCooperate> findBestCooperations(int number);

}
