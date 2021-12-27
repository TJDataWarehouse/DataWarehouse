package com.example.datawarehouse.dao.neo4j;

import com.example.datawarehouse.entity.node.Actor;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ActorRepository extends Neo4jRepository<Actor, Long> {

    @Query("MATCH (a:actor)-[c:cooperateRelation]->(d:director) WHERE d.directorName = $directorName RETURN a")
    List<Actor> findByCooperateDirector(@Param("directorName") String directorName);

    @Query("match(a:actor)-[r:cooperateRelation]->(d:director) " +
            "with count(r) as count_r,a " +
            "where count_r>$times " +
            "return a")
    List<Actor> findActorAndDirectorByCooperateTimesMoreThan(@Param("times") int times);
}
