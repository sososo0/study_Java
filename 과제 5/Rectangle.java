package edu.pnu.shape;

public class Rectangle extends Shape {
    private int width,height;

    public Rectangle(int a, int b, int c, int d){
        this.width = c-a;
        this.height = d-b;
    }
    @Override
    public float getArea(){
        return width*height;
    }
    public String toString(){
        return String.format("[Rectangle %d %d %.2f]",width,height,getArea());
    }
}
