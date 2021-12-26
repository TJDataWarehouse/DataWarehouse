package com.example.datawarehouse.entity.mysql;

import javax.persistence.*;

@Entity
@Table(name = "director_actor_cooperate", schema = "data_warehouse", catalog = "")
public class MysqlDirectorActorCooperate {
    private int id;
    private String director;
    private String actor;
    private Integer cooperate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "director")
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Basic
    @Column(name = "actor")
    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    @Basic
    @Column(name = "cooperate")
    public Integer getCooperate() {
        return cooperate;
    }

    public void setCooperate(Integer cooperate) {
        this.cooperate = cooperate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MysqlDirectorActorCooperate that = (MysqlDirectorActorCooperate) o;

        if (id != that.id) return false;
        if (director != null ? !director.equals(that.director) : that.director != null) return false;
        if (actor != null ? !actor.equals(that.actor) : that.actor != null) return false;
        if (cooperate != null ? !cooperate.equals(that.cooperate) : that.cooperate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (actor != null ? actor.hashCode() : 0);
        result = 31 * result + (cooperate != null ? cooperate.hashCode() : 0);
        return result;
    }
}
