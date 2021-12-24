package com.example.datawarehouse.dao.mysql;

import com.example.datawarehouse.entity.MysqlReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MysqlReviewRepository extends JpaRepository<MysqlReview, Integer> {
}
