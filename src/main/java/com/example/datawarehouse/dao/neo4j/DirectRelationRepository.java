package com.example.datawarehouse.dao.neo4j;

import com.example.datawarehouse.entity.node.Movie;
import com.example.datawarehouse.entity.relation.DirectRelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectRelationRepository extends Neo4jRepository<DirectRelation, Long> {


}
