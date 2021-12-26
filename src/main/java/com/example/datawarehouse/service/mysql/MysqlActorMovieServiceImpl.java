package com.example.datawarehouse.service.mysql;

import com.example.datawarehouse.dao.mysql.MysqlActorMovieRepository;
import com.example.datawarehouse.entity.mysql.MysqlActorMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MysqlActorMovieServiceImpl implements MysqlActorMovieService{
    @Autowired
    MysqlActorMovieRepository mysqlActorMovieRepository;

    @Override
    public List<MysqlActorMovie> findActorMovie(String actorName) {
        return mysqlActorMovieRepository.findMysqlActorMoviesByName(actorName);
    }
}
