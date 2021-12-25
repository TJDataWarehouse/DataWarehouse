package com.example.datawarehouse.entity.mysql;

import javax.persistence.*;

@Entity
@Table(name = "actor_movie", schema = "data_warehouse", catalog = "")
public class MysqlActorMovie {
    private String asin;
    private String name;
    private int id;

    @Basic
    @Column(name = "asin")
    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        MysqlActorMovie that = (MysqlActorMovie) o;

        if (id != that.id) return false;
        if (asin != null ? !asin.equals(that.asin) : that.asin != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = asin != null ? asin.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
