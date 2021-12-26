package com.example.datawarehouse.entity.mysql;

import javax.persistence.*;

@Entity
@Table(name = "actor_actor_cooperate", schema = "data_warehouse", catalog = "")
public class MysqlActorActorCooperate {
    private String actor1;
    private String actor2;
    private Integer cooperate;
    private int id;

    @Basic
    @Column(name = "actor1")
    public String getActor1() {
        return actor1;
    }

    public void setActor1(String actor1) {
        this.actor1 = actor1;
    }

    @Basic
    @Column(name = "actor2")
    public String getActor2() {
        return actor2;
    }

    public void setActor2(String actor2) {
        this.actor2 = actor2;
    }

    @Basic
    @Column(name = "cooperate")
    public Integer getCooperate() {
        return cooperate;
    }

    public void setCooperate(Integer cooperate) {
        this.cooperate = cooperate;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MysqlActorActorCooperate that = (MysqlActorActorCooperate) o;

        if (id != that.id) return false;
        if (actor1 != null ? !actor1.equals(that.actor1) : that.actor1 != null) return false;
        if (actor2 != null ? !actor2.equals(that.actor2) : that.actor2 != null) return false;
        if (cooperate != null ? !cooperate.equals(that.cooperate) : that.cooperate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = actor1 != null ? actor1.hashCode() : 0;
        result = 31 * result + (actor2 != null ? actor2.hashCode() : 0);
        result = 31 * result + (cooperate != null ? cooperate.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
