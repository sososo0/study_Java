package com.bdobe;
import com.bdobe.*;
public abstract class Shape {
    private int lineColor;

    public int getLineColor(){
        return lineColor;
    }
    public void setLineColor(int color){
        lineColor = color;
    }
    public abstract void draw();
    public abstract double getLength();
    public abstract double getArea();
}
