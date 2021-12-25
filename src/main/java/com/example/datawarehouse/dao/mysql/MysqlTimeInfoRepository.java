package com.example.datawarehouse.dao.mysql;


import com.example.datawarehouse.entity.mysql.MysqlTimeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MysqlTimeInfoRepository extends JpaRepository<MysqlTimeInfo,String> {
}
