package com.example.datawarehouse.dao.mysql;

import com.example.datawarehouse.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MysqlMovieRepository extends JpaRepository<Movie, Integer> {
}
