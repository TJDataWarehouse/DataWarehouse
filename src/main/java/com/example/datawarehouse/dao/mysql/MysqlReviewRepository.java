package com.example.datawarehouse.dao.mysql;


import com.example.datawarehouse.entity.mysql.MysqlReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MysqlReviewRepository extends JpaRepository<MysqlReview,Integer> {

    List<MysqlReview> findMysqlReviewsByAsin(String asin);
}
