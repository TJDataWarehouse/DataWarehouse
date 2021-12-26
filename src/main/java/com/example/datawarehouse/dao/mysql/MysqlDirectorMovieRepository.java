package com.example.datawarehouse.dao.mysql;

import com.example.datawarehouse.entity.mysql.MysqlDirectorMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MysqlDirectorMovieRepository extends JpaRepository<MysqlDirectorMovie,Integer> {
    
    List<MysqlDirectorMovie> findMysqlDirectorMoviesByName(String directorrName);
}
