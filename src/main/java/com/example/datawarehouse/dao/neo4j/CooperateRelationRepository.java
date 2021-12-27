package com.example.datawarehouse.dao.neo4j;

import com.example.datawarehouse.entity.relation.CooperateRelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CooperateRelationRepository extends Neo4jRepository<CooperateRelation, Long> {

    @Query("match (a:actor{actorName:$actorName})-[r:cooperateRelation]->(d:director{directorName:$directorName}) return count(r)")
    int countCooperateTimesByActorAndDirector(@Param("actorName") String actorName, @Param("directorName") String directorName);

    @Query("match(a:actor)-[r:cooperateRelation]->(d:director) with count(r) as count_r,a,d where count_r>$times return a,d")
    Object findActorAndDirectorByCooperateTimesMoreThan(@Param("times") int times);
}
