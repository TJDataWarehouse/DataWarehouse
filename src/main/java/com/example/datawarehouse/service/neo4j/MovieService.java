package com.example.datawarehouse.service.neo4j;

import com.example.datawarehouse.dao.neo4j.MovieRepository;
import com.example.datawarehouse.entity.node.Movie;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Resource
    MovieRepository movieRepository;
    String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};

    //按照时间查询电影
    public List<Movie> findMovieByReleaseYear(String releaseYear) {
        return movieRepository.findByReleaseYear(releaseYear);
    }
    public List<Movie> findMovieByReleaseYearAndMonth(String year, String month) {
        return movieRepository.findByReleaseYearAndMonth(year, month);
    }
    public List<Movie> findByQuarterOfYear(String year, int quarter) {
        int startMonth = (quarter - 1) * 3 + 1;
        List<Movie> movieList = new ArrayList<Movie>();
        movieList.addAll(movieRepository.findByReleaseYearAndMonth(year, month[startMonth]));
        movieList.addAll(movieRepository.findByReleaseYearAndMonth(year, month[startMonth+1]));
        movieList.addAll(movieRepository.findByReleaseYearAndMonth(year, month[startMonth+2]));
        return movieList;
    }

    //电影名查询
    public List<Movie> findByMovieName(String movieName) {
        return movieRepository.findByMovieName(movieName);
    }

    //按照导演查询
    public List<Movie> findByDirectorName(String directorName) {
        return movieRepository.findMovieByDirectorName(directorName);
    }

    //按照演员查询
    public List<Movie> findByActorName(String actorName) {
        return movieRepository.findMovieByActorName(actorName);
    }
}