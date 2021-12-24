package com.example.datawarehouse.entity.relation;

import com.example.datawarehouse.entity.node.Actor;
import com.example.datawarehouse.entity.node.Director;
import com.example.datawarehouse.entity.node.Movie;
import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "actRelation")
@Data
@Builder
public class ActRelation {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Movie movie;

    @EndNode
    private Actor actor;
}
