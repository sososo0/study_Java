package edu.pnu.collection;
import edu.pnu.admin.Beverage;
import edu.pnu.collection.*;


public class GenericList<T>{
    private static final int DEFAULT_SIZE = 10;
    private Object[] data;
    private int size=0;

    public GenericList(){
        data = new Object[DEFAULT_SIZE];
    }
    public void add(T element){
        if(data.length==0){
            data = new Object[DEFAULT_SIZE];
            size =0;
        }
        data[size] = element;
        size++;
    }

    public Beverage get(int i){
        return (Beverage) data[i];
    }

    public Object[] clear(){
        data = new Object[0];
        return data;
    }

    public int size(){
        return this.size;
    }

}

