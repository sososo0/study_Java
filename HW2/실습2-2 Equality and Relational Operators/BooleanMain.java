import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BooleanMain {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = new ArrayList<>();
        for(int i = 0 ; i < 2; i++){
            System.out.print("input number ");
            int num = scanner.nextInt();
            integerList.add(num);
        }
        scanner.close();

        int n1 = integerList.get(0);
        int n2 = integerList.get(1);

        System.out.println("\nNumber1 : "+n1+","+" Number2: "+n2);

        boolean a;

        a = (n1 > n2);
        System.out.println("\nNumber1 > Number2? "+a);
        a = (n1 < n2);
        System.out.println("\nNumber1 < Number2? "+a);
        a = (n1 == n2);
        System.out.println("\nNumber1 == Number2? "+a);

    }
}
