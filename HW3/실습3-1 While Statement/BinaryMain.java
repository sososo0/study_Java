import java.util.ArrayList;
import java.util.Scanner;

public class BinaryMain {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> result = new ArrayList<>();
        int num = scanner.nextInt();
        System.out.print("Number " + num+" in Binary Number: ");

        while(num>1){
            if(num%2==0)
                result.add(0);
            else
                result.add(1);

            num = num/2;
        }
        result.add(1);

        for(int i = result.size()-1;0<=i;i--)
            System.out.print(result.get(i));
    }
}

