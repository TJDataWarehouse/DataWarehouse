package com.example.datawarehouse.dao.neo4j;

import com.example.datawarehouse.entity.node.Director;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends Neo4jRepository<Director, Long> {
}
