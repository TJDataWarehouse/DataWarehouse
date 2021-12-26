package com.example.datawarehouse.service.mysql;

import com.example.datawarehouse.dao.mysql.MysqlActorActorCooperateRepository;
import com.example.datawarehouse.dao.mysql.MysqlActorMovieRepository;
import com.example.datawarehouse.dao.mysql.MysqlDirectorActorCooperateRepository;
import com.example.datawarehouse.entity.mysql.MysqlActorActorCooperate;
import com.example.datawarehouse.entity.mysql.MysqlActorMovie;
import com.example.datawarehouse.entity.mysql.MysqlDirectorActorCooperate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class MysqlActorMovieServiceImpl implements MysqlActorMovieService{
    @Autowired
    MysqlActorMovieRepository mysqlActorMovieRepository;
    @Autowired
    MysqlActorActorCooperateRepository mysqlActorActorCooperateRepository;
    @Autowired
    MysqlDirectorActorCooperateRepository mysqlDirectorActorCooperateRepository;

    @Override
    public List<MysqlActorMovie> findActorMovie(String actorName) {
        return mysqlActorMovieRepository.findMysqlActorMoviesByName(actorName);
    }

    @Override
    public List<MysqlActorActorCooperate> findBestPartners(int number) {
        PageRequest pageRequest = PageRequest.of(0,number, Sort.Direction.DESC,"cooperate");
        Page<MysqlActorActorCooperate> actorActorCooperates = mysqlActorActorCooperateRepository.findMysqlActorActorCooperatesByCooperateDesc(pageRequest);
        return actorActorCooperates.getContent();
    }

    @Override
    public List<MysqlDirectorActorCooperate> findBestCooperations(int number) {
        PageRequest pageRequest = PageRequest.of(0,number, Sort.Direction.DESC,"cooperate");
        Page<MysqlDirectorActorCooperate> directorActorCooperates = mysqlDirectorActorCooperateRepository.findMysqlDirectorActorCooperatesByCooperateDesc(pageRequest);
        return directorActorCooperates.getContent();
    }
}
