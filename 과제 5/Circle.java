package edu.pnu.shape;

public class Circle extends Shape {
    private Point center;
    private int radius;

    @Override
    public float getArea(){
        return (float)(radius*radius*Math.PI);
    }

    public Circle(Point center,int radius){
        this.center = center;
        this.radius = radius;
    }
    public String toString(){
        return String.format("[Circle [%d, %d], radius: %d area: %.2f]",center.getX(),center.getY(),radius,getArea());
    }
}