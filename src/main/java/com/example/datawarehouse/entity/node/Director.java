package com.example.datawarehouse.entity.node;

import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label = "director")
@Data
@Builder
public class Director {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "directorName")
    private String directorName;
}
