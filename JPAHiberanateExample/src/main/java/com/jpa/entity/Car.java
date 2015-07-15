package com.jpa.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by c263 on 15.07.2015.
 */

@Entity
@Table(name="cars")
@NamedQuery(name="Car.getAll", query = "select c from Car c")
public class Car {
    public long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="name", length = 32)
    private  String name;
    @Column(name="date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    @Column(name="cost")
    private float cost;

    public Car() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releasDate) {
        this.releaseDate = releasDate;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", releasDate=" + releaseDate +
                ", cost=" + cost +
                '}';
    }
}
