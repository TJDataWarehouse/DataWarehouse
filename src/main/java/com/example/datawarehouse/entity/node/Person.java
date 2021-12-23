package com.example.datawarehouse.entity.node;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import java.io.Serializable;


@NodeEntity(label = "person")
@Data
public class Person implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "pid")
    private String personId;

    @Property(name = "title")
    private String personTitle;

    @Property(name = "name")
    private String personName;

    @Property(name = "height")
    private String personHeight;

    public Person() {

    }
}
