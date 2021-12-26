package com.example.datawarehouse.dao.mysql;


import com.example.datawarehouse.entity.mysql.MysqlMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MysqlMovieRepository extends JpaRepository<MysqlMovie,String> {
    List<MysqlMovie> findMysqlMoviesByMovieNameContaining(String name);

    //查询发布时间包含某字段的电影的数量
    @Query("select count(m) from MysqlMovie m where m.releaseTime like CONCAT('%',:time,'%')")
    int countMysqlMovieByReleaseTimeContaining(@Param("time")String time);

    MysqlMovie findMysqlMovieByMovieName(String movieName);

    List<MysqlMovie> findMysqlMoviesByScoreGreaterThanEqual(double score);

    List<MysqlMovie> findMysqlMoviesByScoreGreaterThan(double score);

    List<MysqlMovie> findMysqlMoviesByScoreLessThanEqual(double score);

    List<MysqlMovie> findMysqlMoviesByScoreLessThan(double score);

    List<MysqlMovie> findMysqlMoviesByScore(double score);

    List<MysqlMovie> findMysqlMoviesByTypeContaining(String type);

    List<MysqlMovie> findMysqlMoviesByReleaseTimeBetween(String date1,String date2);
}
