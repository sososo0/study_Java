package com.bdobe;
import com.bdobe.*;
public class Triangle extends Shape {
    int a,b,c;
    double area;
    double length;

    public Triangle(int a, int b,int c){
        this.a = a; this.b = b; this.c=c;
    }
    @Override
    public double getArea(){
        double s = (a+b+c)/2;
        area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        return area;
    }
    @Override
    public double getLength(){
        length = a+b+c;
        return length;
    }
    @Override
    public void draw(){
        System.out.printf("Triangle, Area: %.2f, Length: %.2f%n",area,length);
    }
}
