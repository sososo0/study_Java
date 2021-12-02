package edu.pnu.edit;

import edu.pnu.shape.Shape;
import java.util.ArrayList;
import java.util.List;

public class Editor {
    private List<Shape> shapes = new ArrayList<>();

    public List add(Shape shape){
        shapes.add(shape);
        return shapes;
    }
    public List clear(){
        shapes.clear();
        return shapes;
    }
    public void list(){
        System.out.println(shapes);
    }
}
