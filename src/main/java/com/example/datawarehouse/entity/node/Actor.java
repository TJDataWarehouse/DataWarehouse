package com.example.datawarehouse.entity.node;

import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label = "actor")
@Data
@Builder
public class Actor {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "actorName")
    private String actorName;
}
