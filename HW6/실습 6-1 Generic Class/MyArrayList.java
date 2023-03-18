public class MyArrayList <T>{
    private Object[] elementData;
    private int size;

    public MyArrayList(int capacity){
        if(capacity > 0){
            this.elementData = new Object[capacity];
        }
    }

    public void add(T data){
        elementData[size++] = data;
    }

    public T get(int index){
        return (T) elementData[index];
    }
}