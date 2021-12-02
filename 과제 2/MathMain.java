import java.util.Arrays;
import java.util.Scanner;

public class MathMain {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = i+1;
        }
        scanner.close();

        int max = getMax(arr);
        System.out.printf("\nMax element : %d in %s%n",max, Arrays.toString(arr));

        int min = getMin(arr);
        System.out.printf("\nMin element : %d in %s%n",min,Arrays.toString(arr));

    }

    private static int getMax(int[] a){
        int M = a[0];
        for(int i=0;i<a.length;i++){
            if(M<a[i])
                M = a[i];
        }
        return M;
    }

    private static int getMin(int[] a){
        int m = a[0];
        for(int i=a.length-1;i>=0;i--){
            if(m>a[i])
                m = a[i];
        }
        return m;
    }
}
