import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OperatorMain {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        List<Integer>integerList = new ArrayList<>();
        for(int i=0; i<2; i++){
            int num = scanner.nextInt();
            integerList.add(num);
        }
        scanner.close();

        int dividend = integerList.get(0);
        int divisor = integerList.get(1);

        double q1 = (double) dividend/divisor;
        String q2 = String.format("%.3f",q1);
        int r = dividend%divisor;
        int q = (int)q1;

        System.out.println(dividend+" / "+divisor+" = "+q2);
        System.out.println(dividend+" = "+q+" x "+divisor+" + "+r);

    }
}
