public class Rectangle implements MyComparable {
    private int width, height, area;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea(){
        area = width*height;
        return area;
    }

    public int compareTo(Object other){
        if(!(other instanceof Rectangle))
            return -2;
        Rectangle otherRectangle = (Rectangle) other;

        int returnValue = 0;
        if(area> otherRectangle.getArea())
            return 1;
        if(area == otherRectangle.getArea())
            return 0;
        if(area< otherRectangle.getArea())
            return -1;

        return returnValue;
    }

    public boolean equal(Object other){
        if(!(other instanceof Rectangle))
            return false;
        Rectangle otherRectangle = (Rectangle) other;
        return width == otherRectangle.width && height == otherRectangle.height;
    }

    public String toString(){
        return "Rectangle{area="+getArea()+"}";
    }
}
