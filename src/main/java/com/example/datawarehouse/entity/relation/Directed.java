package com.example.datawarehouse.entity.relation;

import com.example.datawarehouse.entity.node.Movie;
import com.example.datawarehouse.entity.node.Person;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

@Data
@RelationshipEntity(type = "DIRECTED")
public class Directed {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Movie movie;

    @EndNode
    private Person person;

}
