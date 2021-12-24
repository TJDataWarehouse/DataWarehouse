package com.example.datawarehouse.dao.neo4j;

import com.example.datawarehouse.entity.relation.ActRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActRelationRepository extends Neo4jRepository<ActRelation, Long> {
}
