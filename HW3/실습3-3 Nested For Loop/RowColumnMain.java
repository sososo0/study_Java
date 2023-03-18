import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RowColumnMain {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        List<Integer>integerList = new ArrayList<>();
        System.out.println("Enter two numbers: ");
        for(int i=0;i<2;i++){
            int num = scanner.nextInt();
            integerList.add(num);
        }
        scanner.close();

        int M = integerList.get(0);
        int N = integerList.get(1);

        int [][] matrix = new int [M][N];
        int a = 1;

        for(int j=0;j<M;j++){
            for(int k=0; k<N; k++){
                matrix[j][k] = a;
                System.out.print(matrix[j][k]);
                if(k==N-1) System.out.println("");
                else System.out.print(", ");
                a++;
            }
        }
    }
}