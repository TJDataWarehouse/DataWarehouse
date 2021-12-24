package com.example.datawarehouse.entity.node;

import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label = "movie")
@Data
@Builder
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "asin")
    private String asin;

    @Property(name = "movieName")
    private String movieName;

    @Property(name = "releaseTime")
    private String releaseTime;

    @Property(name = "rating")
    private String rating;

    @Property(name = "format")
    private String format;

    @Property(name = "score")
    private double score;

    @Property(name = "type")
    private String type;
}
