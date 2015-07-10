package com.lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by c263 on 10.07.2015.
 */
public class Task1 {
    public static void main(String[] args){
        List<Human> list=new ArrayList<>(Arrays.asList(
                new Human("Masha",20),
                null,
                new Human("Petia",30)));

        System.out.println(list );
        System.out.println("contains masha :"+ list.contains(new Human("Masha",20)));
    }

}

class Human{
    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String name;
    int age;

    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o==null){
            return false;
        }

        if(this.getClass()!= o.getClass()){
            return false;
        }
        Human h=(Human)o;
        boolean result=this.age==h.age;
        return this.age == h.age && Objects.equals(this.name, h.name);



    }
}
