package com.example.datawarehouse.entity.node;

import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label = "review")
@Data
@Builder
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "asin")
    private String asin;

    @Property(name = "reviewerId")
    private String reviewerId;

    @Property(name = "profileName")
    private String profileName;

    @Property(name = "helpfulness")
    private int helpfulness;

    @Property(name = "score")
    private double score;

    @Property(name = "time")
    private String time;

    @Property(name = "summary")
    private String summary;

    @Property(name = "text")
    private String text;
}
