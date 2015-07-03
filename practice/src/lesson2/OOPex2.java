package lesson2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by c263 on 03.07.2015.
 */
public class OOPex2 {
    public static void main(String[] args){
        Car car= new Car();
        Truck truck=new Truck();

        ArrayList<Car>  list = new ArrayList<>(Arrays.asList(car, truck));
        for(Car c : list){
            c.move();
        }
        ArrayList<Shape> shapes= new ArrayList<>(Arrays.asList(new Square(), new Rectangle()));
    }
}

class Rectangle extends Shape{

    @Override
    public double perim() {
        return 10;
    }

    @Override
    public double area() {
        return 20;
    }
}

class Square extends Shape{

    @Override
    public double perim() {
        return 100;
    }

    @Override
    public double area() {
        return 400;
    }
}

abstract class Shape{
    public abstract double perim();
    public abstract double area();
    @Override
    public String toString(){
        return "perim : "+perim()+", area"+area();
    }
}


class Car{
    public void move(){
        System.out.println("Я машинка еду");
    }
}

class Truck extends Car{
    private int tonnage;
    private int load;
    @Override
    public void move(){
        System.out.println("я грузовик еду");
    }

    public void load(int cargo){
        if (cargo<= tonnage) {
            load = cargo;
        }
            else{
                load=tonnage;
            }

    }
}
