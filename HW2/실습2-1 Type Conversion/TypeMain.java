import java.util.Scanner;

public class TypeMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("input number: \n");
        String x = scanner.nextLine();
        scanner.close();
        printType(x);
        System.out.println("Type conversion to int...\n");
        int x1 = Integer.valueOf(x);
        printType(x1);
        System.out.println("Type conversion int to float...\n");
        float x2 = Float.valueOf(x);
        printType(x2);
    }
        private static void printType(String x){
            System.out.println(x + " is a string\n");
        }

        private static void printType(int x){
            System.out.println(x + " is an int\n");
        }

        private static void printType(float x){
            System.out.println(x + " is a float");
        }
}


