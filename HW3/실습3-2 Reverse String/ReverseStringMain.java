import java.util.Scanner;

public class ReverseStringMain {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        char[] a = str.toCharArray();

        for(int i = str.length()-1; i>=0;i--){
            System.out.print(a[i]);
        }
    }
}
