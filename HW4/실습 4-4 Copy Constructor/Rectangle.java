public class Rectangle {
    private final Point leftTop;
    private final Point rightBottom;

    public Rectangle(Point p1, Point p2){
        leftTop = new Point(p1.getX(),p1.getY());
        rightBottom = new Point(p2.getX(),p2.getY());
    }

    public Rectangle(Rectangle rectangle){
        leftTop = new Point(rectangle.leftTop.getX(),rectangle.leftTop.getY());
        rightBottom = new Point(rectangle.rightBottom.getX(),rectangle.rightBottom.getY());
    }

    public void moveBy(int x, int y){
        leftTop.setX(leftTop.getX()+x);
        leftTop.setY(leftTop.getY()+y);
        rightBottom.setX(rightBottom.getX()+x);
        rightBottom.setY(rightBottom.getY()+y);
    }

    @Override
    public String toString(){
        return "Rectangle[("+leftTop.getX()+", "+leftTop.getY()+"), ("+
                rightBottom.getX()+", "+rightBottom.getY()+")]";
    }
}

