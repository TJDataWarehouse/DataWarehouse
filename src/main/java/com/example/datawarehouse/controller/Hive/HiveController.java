package com.example.datawarehouse.controller.Hive;

import com.example.datawarehouse.entity.hive.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 凉白开不加冰
 * @Version: 0.0.1V
 * @Date: 2019/1/18
 * @Description: 使用JdbcTemplate
 **/
@RestController
@RequestMapping("/hive2")
public class HiveController {

    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    // 某年有多少电影 √
    @RequestMapping("/movie_year_count")
    public Map<String, Object> queryMovieMountByYear(@RequestParam(value = "year", required = true) String year) {
        Map<String, Object> map = new HashMap<>();
        String sql = "select sum(last_1year_count) from dwt_type_topic where year = ?";

        long startTime = System.currentTimeMillis();
        long count = jdbcTemplate.queryForObject(sql, Long.class, year);
        long endTime = System.currentTimeMillis();

        double usedTime = (endTime - startTime);
        String danWei = "ms";
        if (usedTime > 1000) {
            usedTime = usedTime / 1000;
            //保留3位小数
            usedTime = (Math.round(usedTime * 1000) / 1000.0);
            danWei = "s";
        }

        map.put("result", count);
        map.put("used_time", usedTime + danWei);
        return map;
    }

    // 某年某季度有多少电影 √
    @RequestMapping("/movie_year_quarter_count")
    public Map<String, Object> queryMovieMountByYearAndQuarter(@RequestParam(value = "year", required = true) String year, @RequestParam(value = "quarter", required = true) String quarter) {
        Map<String, Object> map = new HashMap<>();
        String sql = "select sum(increase_count) from dws_movie_type_monthcount_new where year = ? and quarter = ?";
        long startTime = System.currentTimeMillis();
        long count = jdbcTemplate.queryForObject(sql, Long.class, year, quarter);
        long endTime = System.currentTimeMillis();

        double usedTime = (endTime - startTime);
        String danWei = "ms";
        if (usedTime > 1000) {
            usedTime = usedTime / 1000;
            //保留3位小数
            usedTime = (Math.round(usedTime * 1000) / 1000.0);
            danWei = "s";
        }

        map.put("result", count);
        map.put("time", usedTime + danWei);
        return map;
    }

    // 某年某月有多少电影 √
    @RequestMapping("/movie_year_month_count")
    public Map<String, Object> queryMovieMountByYearAndMonth(@RequestParam(value = "year", required = true) String year, @RequestParam(value = "month", required = true) String month) {
        Map<String, Object> map = new HashMap<>();
        String sql = "select sum(increase_count) from dws_movie_type_monthcount_new where year = ? and month = ?";
        long startTime = System.currentTimeMillis();
        Long count = jdbcTemplate.queryForObject(sql, Long.class, year, month);
        long endTime = System.currentTimeMillis();
        double usedTime = (endTime - startTime);
        String danWei = "ms";
        if (usedTime > 1000) {
            usedTime = usedTime / 1000;
            //保留3位小数
            usedTime = (Math.round(usedTime * 1000) / 1000.0);
            danWei = "s";
        }

        map.put("result", count);
        map.put("time", usedTime + danWei);
        return map;
    }

    // 某电影有多少版本 √
    @RequestMapping("/movie_format_count")
    public Map<String, Object> queryMovieFormat(@RequestParam(value = "movie_name", required = true) String movie_name) {
        Map<String, Object> map = new HashMap<>();
        String sql = "select format from ods_movie_new_info where movie_name = ?";

        long startTime = System.currentTimeMillis();
        String format = jdbcTemplate.queryForObject(sql, String.class, movie_name);
        long endTime = System.currentTimeMillis();

        double usedTime = (endTime - startTime);
        String danWei = "ms";
        if (usedTime > 1000) {
            usedTime = usedTime / 1000;
            //保留3位小数
            usedTime = (Math.round(usedTime * 1000) / 1000.0);
            danWei = "s";
        }

        map.put("result", format);
        map.put("time", usedTime + danWei);
        return map;
    }

    // 某导演有多少电影 √
    @RequestMapping("/director_movie_count")
    public Map<String, Object> queryDirectorMovieCount(@RequestParam(value = "director_name", required = true) String director_name) {
        Map<String, Object> map = new HashMap<>();
        String sql = "select movie_count from dwt_director_topic where director_name = ?";

        long startTime = System.currentTimeMillis();
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, director_name);
        long endTime = System.currentTimeMillis();

        double usedTime = (endTime - startTime);
        String danWei = "ms";
        if (usedTime > 1000) {
            usedTime = usedTime / 1000;
            //保留3位小数
            usedTime = (Math.round(usedTime * 1000) / 1000.0);
            danWei = "s";
        }

        map.put("result", count);
        map.put("time", usedTime + danWei);
        return map;
    }

    // 某演员有多少电影 √
    @RequestMapping("/actor_movie_count")
    public Map<String, Object> queryActorMovieCount(@RequestParam(value = "actor_name", required = true) String actor_name) {
        Map<String, Object> map = new HashMap<>();
        String sql = "select movie_count from dwt_actor_topic where actor_name = ?";

        long startTime = System.currentTimeMillis();
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, actor_name);
        long endTime = System.currentTimeMillis();

        double usedTime = (endTime - startTime);
        String danWei = "ms";
        if (usedTime > 1000) {
            usedTime = usedTime / 1000;
            //保留3位小数
            usedTime = (Math.round(usedTime * 1000) / 1000.0);
            danWei = "s";
        }

        map.put("result", count);
        map.put("time", usedTime + danWei);
        return map;
    }

    // 某类型电影有多少
    @RequestMapping("movie_type_count")
    public Map<String, Object> queryMovieTypeCount(@RequestParam(value = "type", required = true) String type) {
        Map<String, Object> map = new HashMap<>();
        String sql = "select sum(movie_count) from ads_movie_type_topn where type like concat('%',?,'%')";
        long startTime = System.currentTimeMillis();
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, type);
        long endTime = System.currentTimeMillis();

        double usedTime = (endTime - startTime);
        String danWei = "ms";
        if (usedTime > 1000) {
            usedTime = usedTime / 1000;
            //保留3位小数
            usedTime = (Math.round(usedTime * 1000) / 1000.0);
            danWei = "s";
        }

        map.put("result", count);
        map.put("time", usedTime + danWei);
        return map;
    }

    // n分以上的电影有多少部
    @RequestMapping("movie_score_count")
    public Map<String, Object> queryMovieCountByScore(@RequestParam(value = "score", required = true) String score) {
        Map<String, Object> map = new HashMap<>();
        String sql = "select count(1) from dwd_fact_movie_info where score >= ?";

        long startTime = System.currentTimeMillis();
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, score);
        long endTime = System.currentTimeMillis();

        double usedTime = (endTime - startTime);
        String danWei = "ms";
        if (usedTime > 1000) {
            usedTime = usedTime / 1000;
            //保留3位小数
            usedTime = (Math.round(usedTime * 1000) / 1000.0);
            danWei = "s";
        }

        map.put("result", count);
        map.put("time", usedTime + danWei);
        return map;
    }

    // 好评率大于n的电影数量 √
    @RequestMapping("movie_good_review_rate")
    public Map<String, Object> queryMovieGoodReviewRate(@RequestParam(value = "rate", required = true) String rate) {
        Map<String, Object> map = new HashMap<>();
        String sql = "select count(1) from ads_movie_heat_topN_new where round(review_good_count/review_count,2) >= ?";

        long startTime = System.currentTimeMillis();
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, rate);
        long endTime = System.currentTimeMillis();

        double usedTime = (endTime - startTime);
        String danWei = "ms";
        if (usedTime > 1000) {
            usedTime = usedTime / 1000;
            //保留3位小数
            usedTime = (Math.round(usedTime * 1000) / 1000.0);
            danWei = "s";
        }

        map.put("result", count);
        map.put("time", usedTime + danWei);
        return map;
    }

    // 对电影类型排名--按评分或数量
    @RequestMapping("movie_type_rank")
    public Map<String, Object> queryTypeRank(@RequestParam(value = "value", required = true) String value) {
        Map<String, Object> map = new HashMap<>();
        String sql1 = "select type,movie_count from ads_movie_type_topN order by movie_count desc";
        String sql2 = "select type,score from ads_movie_type_topN order by score desc";
        List<MovieTypeRankByCount> resultList1 = null;
        List<MovieTypeRankByScore> resultList2 = null;
        long startTime = System.currentTimeMillis();
        if ("count".equals(value)) {
            resultList1 = jdbcTemplate.query(sql1, new Object[]{}, new BeanPropertyRowMapper<MovieTypeRankByCount>(MovieTypeRankByCount.class));
        } else if ("score".equals(value)) {
            resultList2 = jdbcTemplate.query(sql2, new Object[]{}, new BeanPropertyRowMapper<MovieTypeRankByScore>(MovieTypeRankByScore.class));
        }
        long endTime = System.currentTimeMillis();

        double usedTime = (endTime - startTime);
        String danWei = "ms";
        if (usedTime > 1000) {
            usedTime = usedTime / 1000;
            //保留3位小数
            usedTime = (Math.round(usedTime * 1000) / 1000.0);
            danWei = "s";
        }
        if (resultList1 != null) {
            resultList1 = resultList1.subList(0, 11);
            map.put("result", resultList1);
        } else {
            resultList2 = resultList2.subList(0, 11);
            map.put("result", resultList2);
        }
        map.put("time", usedTime + danWei);
        return map;
    }

    // 对电影排名--按总评论数或好评数
    @RequestMapping("movie_rank")
    public Map<String, Object> queryMovieRank(@RequestParam(value = "value", required = true) String value) {
        Map<String, Object> map = new HashMap<>();
        String sql1 = "select asin,review_count from ads_movie_heat_topN_new order by review_count desc";
        String sql2 = "select asin,review_good_count from ads_movie_heat_topN_new order by review_good_count desc";
        List<MovieRankByReview> resultList1 = null;
        List<MovieRankByGoodReivew> resultList2 = null;
        long startTime = System.currentTimeMillis();
        if ("review_count".equals(value)) {
            resultList1 = jdbcTemplate.query(sql1, new Object[]{}, new BeanPropertyRowMapper<MovieRankByReview>(MovieRankByReview.class));
        } else if ("review_good_count".equals(value)) {
            resultList2 = jdbcTemplate.query(sql2, new Object[]{}, new BeanPropertyRowMapper<MovieRankByGoodReivew>(MovieRankByGoodReivew.class));
        }
        long endTime = System.currentTimeMillis();

        double usedTime = (endTime - startTime);
        String danWei = "ms";
        if (usedTime > 1000) {
            usedTime = usedTime / 1000;
            //保留3位小数
            usedTime = (Math.round(usedTime * 1000) / 1000.0);
            danWei = "s";
        }
        if (resultList1 != null) {
            resultList1 = resultList1.subList(0, 11);
            map.put("result", resultList1);
        } else {
            resultList2 = resultList2.subList(0, 11);
            map.put("result", resultList2);
        }
        map.put("time", usedTime + danWei);
        return map;
    }
}

