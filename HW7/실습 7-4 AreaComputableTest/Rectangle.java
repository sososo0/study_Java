public class Rectangle implements MyComparable,AreaComputable{
    private int width, height;

    public Rectangle(int width, int height){
        this.height = height;
        this.width = width;
    }

    public float getArea(){
        return (float) width*height;
    }

    public int compareTo(Object other){
        if(!(other instanceof Rectangle))
            return -2;
        Rectangle rectangle = (Rectangle) other;
        int returnValue=0;
        if(getArea()> rectangle.getArea())
            returnValue = 1;
        if(getArea() == rectangle.getArea())
            returnValue = 0;
        if(getArea() < rectangle.getArea())
            returnValue = -1;

        return returnValue;
    }
    public boolean equal(Object other){
        if(!(other instanceof Rectangle))
            return false;
        Rectangle otherRectangle = (Rectangle) other;
        return width==otherRectangle.width && height == otherRectangle.height;
    }

    public String toString(){
        return "Rectangle{Width:\t"+width+", Height:\t"+height+"}";
    }

}
