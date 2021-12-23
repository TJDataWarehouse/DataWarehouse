package com.example.datawarehouse;

import com.example.datawarehouse.dao.neo4j.MovieRepository;
import com.example.datawarehouse.dao.neo4j.PersonRepository;
import com.example.datawarehouse.entity.node.Movie;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
class DataWarehouseApplicationTests {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void test() {
        System.out.println("hello");
        System.out.println(movieRepository.findAll());

        Movie movie = new Movie();
        movieRepository.save(movie);
    }

}
