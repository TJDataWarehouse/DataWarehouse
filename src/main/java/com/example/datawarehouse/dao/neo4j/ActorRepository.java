package com.example.datawarehouse.dao.neo4j;

import com.example.datawarehouse.entity.node.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ActorRepository extends Neo4jRepository<Actor, Long> {

//    @Query("MATCH (a:actor)-[c:cooperateRelation]->(d:director) WHERE d.directorName = $directorName RETURN a")
//    List<Actor> findByCooperateDirector(@Param("directorName") String directorName);

}
