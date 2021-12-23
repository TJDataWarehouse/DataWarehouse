package com.example.datawarehouse.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "director")
    private String director;
}
