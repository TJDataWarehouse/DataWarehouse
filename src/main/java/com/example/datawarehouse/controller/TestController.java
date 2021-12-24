package com.example.datawarehouse.controller;

import com.example.datawarehouse.dao.mysql.MysqlMovieRepository;
import com.example.datawarehouse.dao.mysql.MysqlReviewRepository;
import com.example.datawarehouse.dao.neo4j.*;
import com.example.datawarehouse.entity.MysqlMovie;
import com.example.datawarehouse.entity.MysqlReview;
import com.example.datawarehouse.entity.node.Actor;
import com.example.datawarehouse.entity.node.Director;
import com.example.datawarehouse.entity.node.Movie;
import com.example.datawarehouse.entity.node.Review;
import com.example.datawarehouse.entity.relation.ActRelation;
import com.example.datawarehouse.entity.relation.CooperateRelation;
import com.example.datawarehouse.entity.relation.DirectRelation;
import com.example.datawarehouse.entity.relation.ReviewRelation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class TestController {
    @Resource
    private MovieRepository movieRepository;
    @Resource
    private MysqlMovieRepository mysqlMovieRepository;
    @Resource
    private ActorRepository actorRepository;
    @Resource
    private DirectorRepository directorRepository;
    @Resource
    private MysqlReviewRepository mysqlReviewRepository;
    @Resource
    private ReviewRepository reviewRepository;
    @Resource
    private ActRelationRepository actRelationRepository;
    @Resource
    private DirectRelationRepository directRelationRepository;
    @Resource
    private CooperateRelationRepository cooperateRelationRepository;
    @Resource
    private ReviewRelationRepository reviewRelationRepository;

    @GetMapping("create")
    public void create() {
        //获取MySQL数据源
        List<MysqlMovie> mysqlMovieList = mysqlMovieRepository.findAll();
        List<MysqlReview> mysqlReviewList = (List<MysqlReview>) mysqlReviewRepository.findAll();

        //创建neo4j存储列表，以方便使用saveAll函数插入
        List<Movie> movieList = new ArrayList<Movie>();
        List<Review> reviewList = new ArrayList<Review>();
        List<CooperateRelation> cooperateRelationList = new ArrayList<CooperateRelation>();
        List<ReviewRelation> reviewRelationList = new ArrayList<ReviewRelation>();

        //插入movie，actor，director节点与关系
        for (MysqlMovie mysqlMovie : mysqlMovieList) {

            //在每遍历一条电影时，创建局部列表：act关系，direct关系，actor节点，director节点
            List<ActRelation> actRelationList = new ArrayList<ActRelation>();
            List<DirectRelation> directRelationList = new ArrayList<DirectRelation>();
            List<Actor> actorList = new ArrayList<Actor>();
            List<Director> directorList = new ArrayList<Director>();

            //存储单元数据movie
            Movie movie = Movie.builder()
                    .asin(mysqlMovie.getAsin())
                    .movieName(mysqlMovie.getMovieName())
                    .releaseTime(mysqlMovie.getReleaseTime())
                    .rating(mysqlMovie.getRating())
                    .format(mysqlMovie.getFormat())
                    .score(mysqlMovie.getScore())
                    .type(mysqlMovie.getType())
                    .build();

            //加入movie列表
            movieList.add(movie);

            //遍历movie中的所有演员，存储 1.演员节点 2.act关系
            for (String actorName : mysqlMovie.getActors().split(",")) {
                if (!Objects.equals(actorName, "null")) {
                    Actor actor = Actor.builder().actorName(actorName).build();
                    actorList.add(actor);
                    ActRelation actRelation = ActRelation.builder().movie(movie).actor(actor).build();
                    actRelationList.add(actRelation);
                }
            }

            //遍历movie中的所有导演，存储 1.导演节点 2.direct关系 3.演员和导演合作关系
            for (String directorName : mysqlMovie.getDirectors().split(",")) {
                if (!Objects.equals(directorName, "null")) {
                    Director director = Director.builder().directorName(directorName).build();
                    directorList.add(director);
                    DirectRelation directRelation = DirectRelation.builder().movie(movie).director(director).build();
                    directRelationList.add(directRelation);
                    for (Actor actor : actorList) {
                        CooperateRelation cooperateRelation = CooperateRelation.builder().director(director).actor(actor).build();
                        cooperateRelationRepository.save(cooperateRelation);
                    }
                }
            }

            directRelationRepository.saveAll(directRelationList);
            actRelationRepository.saveAll(actRelationList);

            actorRepository.saveAll(actorList);
            directorRepository.saveAll(directorList);
        }
        movieRepository.saveAll(movieList);

        //插入review节点与关系
        for (MysqlReview mysqlReview : mysqlReviewList) {
            Review review = Review.builder()
                    .reviewerId(mysqlReview.getReviewerId())
                    .profileName(mysqlReview.getProfileName())
                    .helpfulness(mysqlReview.getHelpfulness())
                    .score(mysqlReview.getScore())
                    .time(mysqlReview.getTime())
                    .summary(mysqlReview.getSummary())
                    .text(mysqlReview.getText())
                    .asin(mysqlReview.getAsin())
                    .build();

            reviewList.add(review);

            for (Movie movie : movieList) {
                if (Objects.equals(movie.getAsin(), review.getAsin())) {
                    ReviewRelation reviewRelation = ReviewRelation.builder().movie(movie).review(review).build();
                    reviewRelationRepository.save(reviewRelation);
                }
            }

        }
        reviewRepository.saveAll(reviewList);

    }
}