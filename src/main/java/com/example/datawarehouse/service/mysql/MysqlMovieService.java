package com.example.datawarehouse.service.mysql;


import com.example.datawarehouse.entity.mysql.MysqlActorMovie;
import com.example.datawarehouse.entity.mysql.MysqlMovie;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MysqlMovieService {

    @Resource
    MysqlActorMovie mysqlActorMovie;

}
