import java.util.Arrays;
import java.util.Scanner;

public class ArrayCopyMain {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int [] original = new int [N];
        for(int i=0; i<N ; i++){
            original[i] = scanner.nextInt();
        }
        scanner.close();

        int [] shallow = original;
        int [] deep = new int[original.length];

        modifyArray(shallow,1);
        System.out.println("Shallow Copy: "+ Arrays.toString(original));

        modifyArray(deep,2);
        System.out.println("Deep Copy: "+ Arrays.toString(original));
    }
    private static void modifyArray(int[] array, int index){
        array[index] = 15;
    }
}