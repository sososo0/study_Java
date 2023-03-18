package com.bdobe;
import com.bdobe.*;
public class Rectangle extends Shape{
    int width;
    int height;
    double area;
    double length;

    public Rectangle(int width,int height){
        this.width = width;
        this.height = height;
    }
    @Override
    public double getArea(){
        area = width*height;
        return area;
    }
    @Override
    public double getLength(){
        length = 2*(width+length);
        return length;
    }
    @Override
    public void draw(){
        System.out.printf("Rectangle, Area: %.2f, Length: %.2f%n",area,length);
    }
}
