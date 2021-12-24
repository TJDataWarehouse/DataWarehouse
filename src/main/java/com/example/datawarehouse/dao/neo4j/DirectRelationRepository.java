package com.example.datawarehouse.dao.neo4j;

import com.example.datawarehouse.entity.relation.DirectRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectRelationRepository extends Neo4jRepository<DirectRelation, Long> {
}
