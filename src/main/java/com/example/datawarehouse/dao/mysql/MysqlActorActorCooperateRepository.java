package com.example.datawarehouse.dao.mysql;

import com.example.datawarehouse.entity.mysql.MysqlActorActorCooperate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MysqlActorActorCooperateRepository extends JpaRepository<com.example.datawarehouse.entity.mysql.MysqlActorActorCooperate,Integer> {

    @Query("select a from MysqlActorActorCooperate a")
    Page<MysqlActorActorCooperate> findMysqlActorActorCooperatesByCooperateDesc(PageRequest pageRequest);
}
