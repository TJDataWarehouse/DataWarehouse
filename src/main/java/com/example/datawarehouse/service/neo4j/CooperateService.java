package com.example.datawarehouse.service.neo4j;

import com.example.datawarehouse.dao.neo4j.ActorRepository;
import com.example.datawarehouse.dao.neo4j.CooperateRelationRepository;
import com.example.datawarehouse.dao.neo4j.DirectorRepository;
import com.example.datawarehouse.entity.node.Actor;
import com.example.datawarehouse.entity.node.Director;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CooperateService {

    @Resource
    private ActorRepository actorRepository;
    @Resource
    private DirectorRepository directorRepository;
    @Resource
    private CooperateRelationRepository cooperateRelationRepository;

    public List<Director> findByCooperateActor(String actorName) {
        return directorRepository.findByCooperateActor(actorName);
    }

    public List<Actor> findByCooperateDirector(String directorName) {
        return actorRepository.findByCooperateDirector(directorName);
    }

    public void times(int times) {
//        List<Actor> actorList = actorRepository.findActorAndDirectorByCooperateTimesMoreThan(times);
//        List<Director> directorList = directorRepository.findActorAndDirectorByCooperateTimesMoreThan(times);
//        System.out.println(actorList.size());
//        System.out.println(directorList.size());
//        List<Cooperation> cooperationList = new ArrayList<Cooperation>();
//        for (int i=0; i<actorList.size(); i++) {
//            Cooperation cooperation = Cooperation.builder().actor(actorList.get(i)).director(directorList.get(i)).build();
//            cooperationList.add(cooperation);
//        }
//        return cooperationList;

        Object cooperationList = cooperateRelationRepository.findActorAndDirectorByCooperateTimesMoreThan(times);
        System.out.println(cooperationList);

    }

}
