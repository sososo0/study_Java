public class Rectangle {

    private final Point leftTop;
    private final Point rightBottom;

    public Rectangle(Point p1,Point p2){
        leftTop = p1;
        rightBottom = p2;
    }

    public void moveBy(int x, int y){
        leftTop.setX(leftTop.getX()+x);
        leftTop.setY(leftTop.getY()+y);
        rightBottom.setX(rightBottom.getX()+x);
        rightBottom.setY(rightBottom.getY()+y);
    }

    public void moveBy(int position){
        leftTop.setX(leftTop.getX()+position);
        leftTop.setY(leftTop.getY()+position);
        rightBottom.setX(rightBottom.getX()+position);
        rightBottom.setY(rightBottom.getY()+position);
    }


    @Override
    public String toString(){
        return "Rectangle[("+leftTop.getX()+","+leftTop.getY()+"), ("+
                rightBottom.getX()+","+rightBottom.getY()+")]";
    }
}
