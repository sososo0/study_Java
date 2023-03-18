package com.bdobe;
import com.bdobe.*;
public class Circle extends Shape{
    int radius;
    double area;
    double length;

    public Circle(int radius){
        this.radius = radius;
    }
    @Override
    public double getArea(){
        area= Math.PI*radius*radius;
        return area;
    }
    @Override
    public double getLength(){
        length = 2*Math.PI*radius;
        return length;
    }
    @Override
    public void draw(){
        System.out.printf("Circle, Area: %.2f, Length: %.2f%n",area,length);
    }

}
