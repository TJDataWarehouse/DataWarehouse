package com.example.datawarehouse.controller.neo4j;

import com.example.datawarehouse.entity.node.Actor;
import com.example.datawarehouse.entity.node.Director;
import com.example.datawarehouse.service.neo4j.CooperateService;
import com.example.datawarehouse.utils.ApiResult;
import com.example.datawarehouse.utils.ApiResultHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/neo4j")
public class Neo4jCooperateController {

    @Resource
    private CooperateService cooperateService;

    private long runTime = 0;

    @GetMapping("/cooperateWithDirector")
    public ApiResult queryActorListByDirector(@RequestParam("director_name") String directorName) {
        long startTime = System.currentTimeMillis();
        List<Actor> actorList = cooperateService.findByCooperateDirector(directorName);
        long endTime = System.currentTimeMillis();
        runTime = endTime - startTime;
        return ApiResultHandler.buildApiResult(runTime, 200, "", actorList);
    }

    @GetMapping("/cooperateWithActor")
    public ApiResult queryDirectorListByActor(@RequestParam("actor_name") String actorName) {
        long startTime = System.currentTimeMillis();
        List<Director> directorList = cooperateService.findByCooperateActor(actorName);
        long endTime = System.currentTimeMillis();
        runTime = endTime - startTime;
        return ApiResultHandler.buildApiResult(runTime, 200, "", directorList);
    }

    @GetMapping("/cooperateTimes")
    public ApiResult Times(@RequestParam("times") int times) {
        long startTime = System.currentTimeMillis();
        System.out.println(times);
        cooperateService.times(times);
//        System.out.println(cooperationList);
        long endTime = System.currentTimeMillis();
        runTime = endTime - startTime;
        return ApiResultHandler.buildApiResult(runTime, 200, "", null);
    }



}
