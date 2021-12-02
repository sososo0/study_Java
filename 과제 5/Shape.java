package edu.pnu.shape;

public abstract class Shape{
    private int linecolor;
    public abstract float getArea();

    public int getLinecolor(){
        return linecolor;
    }
    public void setLinecolor(int color){
        linecolor = color;
    }
}
