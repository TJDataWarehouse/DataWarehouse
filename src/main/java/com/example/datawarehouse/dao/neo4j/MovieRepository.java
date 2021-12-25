package com.example.datawarehouse.dao.neo4j;

import com.example.datawarehouse.entity.node.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {

    @Query("MATCH (n) WHERE n.releaseTime ends with $year RETURN n")
    List<Movie> findByReleaseYear(@Param("year") String year);

    @Query("MATCH (n) WHERE n.releaseTime ends with $year and n.releaseTime starts with $month RETURN n")
    List<Movie> findByReleaseYearAndMonth(@Param("year") String year, @Param("month") String month);

    List<Movie> findByMovieName(String movieName);

    @Query("MATCH (m:movie)-[r:directRelation]->(d:director) WHERE d.directorName = $directorName RETURN m")
    List<Movie> findMovieByDirectorName(@Param("directorName") String directorName);

    @Query("MATCH (m:movie)-[a:actRelation]->(atr:actor) WHERE atr.actorName = $actorName RETURN m")
    List<Movie> findMovieByActorName(@Param("actorName") String actorName);

    List<Movie> findByType(String type);

    List<Movie> findByScoreGreaterThan(double score);

}
