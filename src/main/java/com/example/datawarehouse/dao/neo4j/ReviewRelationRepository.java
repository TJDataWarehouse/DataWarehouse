package com.example.datawarehouse.dao.neo4j;

import com.example.datawarehouse.entity.relation.ReviewRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRelationRepository extends Neo4jRepository<ReviewRelation, Long> {
}
