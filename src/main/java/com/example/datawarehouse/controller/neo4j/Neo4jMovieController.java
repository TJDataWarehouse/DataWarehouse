package com.example.datawarehouse.controller.neo4j;

import com.example.datawarehouse.entity.node.Movie;
import com.example.datawarehouse.service.neo4j.MovieService;
import com.example.datawarehouse.utils.ApiResult;
import com.example.datawarehouse.utils.ApiResultHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/neo4j")
public class Neo4jMovieController {

    @Resource
    MovieService movieService;

    private long runTime = 0;

    @GetMapping("/byName")
    public ApiResult queryByMovieName(@RequestParam("movie_name") String movieName) {
        System.out.println(movieName);
        long startTime = System.currentTimeMillis();
        List<Movie> movieList = movieService.findByMovieName(movieName);
        long endTime = System.currentTimeMillis();
        runTime = endTime - startTime;
        return ApiResultHandler.buildApiResult(runTime, 200, "", movieList);
    }

    @GetMapping("/byDirectorName")
    public ApiResult queryByDirectorName(@RequestParam("director_name") String directorName) {
        System.out.println(directorName);
        long startTime = System.currentTimeMillis();
        List<Movie> movieList = movieService.findByDirectorName(directorName);
        System.out.println(movieList);
        long endTime = System.currentTimeMillis();
        runTime = endTime - startTime;
        return ApiResultHandler.buildApiResult(runTime, 200, "", movieList);
    }

    @GetMapping("/byActorName")
    public ApiResult queryByActorName(@RequestParam("actor_name") String actorName) {
        long startTime = System.currentTimeMillis();
        List<Movie> movieList = movieService.findByActorName(actorName);
        long endTime = System.currentTimeMillis();
        runTime = endTime - startTime;
        return ApiResultHandler.buildApiResult(runTime, 200, "", movieList);
    }

    @GetMapping("/byMovieType")
    public ApiResult queryByMovieType(@RequestParam("type") String type) {
        long startTime = System.currentTimeMillis();
        List<Movie> movieList = movieService.findByMovieType(type);
        long endTime = System.currentTimeMillis();
        runTime = endTime - startTime;
        return ApiResultHandler.buildApiResult(runTime, 200, "", movieList);
    }

    @GetMapping("/byMovieScore")
    public ApiResult queryByMovieScore(@RequestParam("score") double score) {
        long startTime = System.currentTimeMillis();
        List<Movie> movieList = movieService.findByScoreGreaterThan(score);
        long endTime = System.currentTimeMillis();
        runTime = endTime - startTime;
        return ApiResultHandler.buildApiResult(runTime, 200, "", movieList);
    }

}
