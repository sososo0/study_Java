import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrimeNumberMain {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();

        for(int i=2 ; i <= num; i++){
            System.out.println("Prime Numbers less than or equal to "+i+
                    " = "+ Arrays.toString(getPrimeNumber(i)));
        }
    }
    private static Integer[] getPrimeNumber(final int n) {
        List<Integer>integerList = new ArrayList<>();

        for(int j=2; j<=n; j++){
            int count = 0;

            for(int k=2; k<=j; k++){

                if(j%k == 0){
                    count++;
                }
            }
            if(count == 1){
                integerList.add(j);
            }
        }
        Integer[] getPrimeNumber = integerList.toArray(new Integer[integerList.size()]);
        return getPrimeNumber ;
    }
}
