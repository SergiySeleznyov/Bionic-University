package com.jpa.entity;

import javax.persistence.*;

/**
 * Created by c263 on 15.07.2015.
 */

@Entity
@Table(name="sellers")
@NamedQuery(name="Seller.getAll", query = "select s from Seller s")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="fullName", length = 32)
    private String fullName; // Полное имя
    @Column(name="age")
    private int age;         // Возвраст
    @Column(name="salary")
    private float salary;    // Зар. плата

    public Seller(String fullName, int age, float salary) {
        this.fullName = fullName;
        this.age = age;
        this.salary = salary;
    }

    public Seller() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
