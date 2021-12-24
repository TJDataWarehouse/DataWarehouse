package com.example.datawarehouse.dao.neo4j;

import com.example.datawarehouse.entity.node.Actor;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends Neo4jRepository<Actor, Long> {
}
