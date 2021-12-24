package com.example.datawarehouse.entity.relation;

import com.example.datawarehouse.entity.node.Movie;
import com.example.datawarehouse.entity.node.Review;
import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "reviewRelation")
@Data
@Builder
public class ReviewRelation {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Movie movie;

    @EndNode
    private Review review;
}
