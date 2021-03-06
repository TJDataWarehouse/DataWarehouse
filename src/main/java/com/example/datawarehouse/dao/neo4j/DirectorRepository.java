package com.example.datawarehouse.dao.neo4j;

import com.example.datawarehouse.entity.node.Actor;
import com.example.datawarehouse.entity.node.Director;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DirectorRepository extends Neo4jRepository<Director, Long> {

    @Query("MATCH (a:actor)-[c:cooperateRelation]->(d:director) WHERE a.actorName = $actorName RETURN d")
    List<Director> findByCooperateActor(@Param("actorName") String actorName);

    @Query("match(a:actor)-[r:cooperateRelation]->(d:director) " +
            "with count(r) as count_r,d " +
            "where count_r>$times " +
            "return d")
    List<Director> findActorAndDirectorByCooperateTimesMoreThan(@Param("times") int times);
}
