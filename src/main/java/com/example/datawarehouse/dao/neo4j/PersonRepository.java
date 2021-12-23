package com.example.datawarehouse.dao.neo4j;

import com.example.datawarehouse.entity.node.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {

}
