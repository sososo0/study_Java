@FunctionalInterface
public interface MyFunction{
    public abstract void run();

    static MyFunction getMyFunction(String s){
        MyFunction f = () -> System.out.println(s+".run()");
        return f;
    }

    default void sayHello(){
        System.out.println("Hello");
    }
}
