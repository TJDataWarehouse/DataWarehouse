package com.example.datawarehouse.dao.mysql;

import com.example.datawarehouse.entity.mysql.MysqlActorMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MysqlActorMovieRepository extends JpaRepository<MysqlActorMovie,Integer> {

    List<MysqlActorMovie> findMysqlActorMoviesByName(String actorName);
}
