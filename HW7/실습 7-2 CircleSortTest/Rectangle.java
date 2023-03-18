public class Rectangle implements MyComparable{
    private int width, height, area;

    public Rectangle(int width,int height){
        this.width = width;
        this.height = height;
    }

    public int getArea(){
        area = width*height;
        return area;
    }

    @Override
    public int compareTo(Object other){
        if(!(other instanceof Rectangle))
            return -2;

        int returnValue=0;
        Rectangle otherRectangle = (Rectangle) other;
        if(area> otherRectangle.getArea())
            returnValue = 1;
        if(area == otherRectangle.getArea())
            returnValue =0;
        if(area < otherRectangle.getArea())
            returnValue = -1;
        return returnValue;
    }

    @Override
    public boolean equal(Object other){
        if(!(other instanceof Rectangle))
            return false;
        Rectangle otherRectangle = (Rectangle) other;
        return width == otherRectangle.width && height == otherRectangle.height;
    }

    @Override
    public String toString(){
        return "Rectangle{area="+getArea()+"}";
    }
}
