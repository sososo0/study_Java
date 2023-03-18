import java.lang.reflect.Constructor;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class ReflectionTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String arg1 = sc.next();
        Double arg2 = sc.nextDouble();
        sc.close();

        String className = "Employee";
        Class[] cArgs = new Class[2];
        cArgs[0] = String.class;
        cArgs[1] = Double.class;

        Employee employee1 = null;

        try {
            final Class<?> cl = Class.forName(className);
            final Constructor<?> con = cl.getConstructor(cArgs);
            employee1 = (Employee) con.newInstance(arg1,arg2);
            employee1.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(employee1);
    }
}
