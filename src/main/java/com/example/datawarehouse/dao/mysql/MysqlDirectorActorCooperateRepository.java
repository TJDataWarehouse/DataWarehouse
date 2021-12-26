package com.example.datawarehouse.dao.mysql;

import com.example.datawarehouse.entity.mysql.MysqlDirectorActorCooperate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MysqlDirectorActorCooperateRepository extends JpaRepository<MysqlDirectorActorCooperate,Integer> {
    @Query("select d from MysqlDirectorActorCooperate d ")
    Page<MysqlDirectorActorCooperate> findMysqlDirectorActorCooperatesByCooperateDesc(PageRequest pageRequest);
}
