import java.util.Scanner;

public class ArrayEnum {
    enum Command {
        QUIT, ADD, LIST, SUM, SRTA, SRTD, INVALID
    }

    enum Order {ASC, DESC}

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        int[] values = new int[100];
        int index = 0;
        Order order = Order.ASC;
        Order order1 = Order.DESC;

        while (true) {

            String str = scanner.nextLine();
            final Command command = getCommand(str);

            if (command == Command.QUIT) {
                System.out.println("Bye!");
                break;
            }
            switch (command) {
                case ADD: {
                    final int newValue = getValue(str);
                    values[index] = newValue;
                    index = index + 1;
                    break;
                }
                case LIST: {
                    values = printList(values, index);
                    System.out.printf("%n");
                    break;
                }
                case SRTA: {
                    values = printList(sort(values, index, Order.ASC), index);
                    System.out.printf("%n");
                    break;
                }
                case SRTD: {
                    values = printList2(sort(values, index, Order.DESC), index);
                    System.out.printf("%n");
                    break;
                }
                case SUM: {
                    sum(values, index);
                    break;
                }
                case QUIT: {
                    System.out.println("Bye!");
                    break;
                }
                case INVALID: {
                    System.out.println("Invalid Command");
                    break;
                }
            }
        }
        scanner.close();
    }

    private static int getValue(String a) {
        String[] as = a.split("\\s");
        Integer index = Integer.valueOf(as[1]);
        return index;
    }

    private static Command getCommand(String a) {
        String[] strs = a.split("\\s");

        if (strs.length == 2) {
            return Command.ADD;
        } else {
            String STR = a.toUpperCase();

            if (STR.equals(Command.ADD.name())) {
                return Command.ADD;
            } else if (STR.equals(Command.LIST.name())) {
                return Command.LIST;
            } else if (STR.equals(Command.SRTA.name())) {
                return Command.SRTA;
            } else if (STR.equals(Command.SRTD.name())) {
                return Command.SRTD;
            } else if (STR.equals(Command.SUM.name())) {
                return Command.SUM;
            } else if (STR.equals(Command.QUIT.name())) {
                return Command.QUIT;
            } else return Command.INVALID;
        }
    }

    private static int[] printList(int[] a, int num) {

        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i = 0; i < num; i++) {
            System.out.print(a[i] + " ");
        }
        return a;
    }

    private static int[] printList2(int[] a, int num) {
        for (int i = 0; i < num; i++) {
            System.out.print(a[i] + " ");
        }
        return a;
    }
    private static int[] sort(int[]a,int b,Order order){
        for (int i = 0; i < b; i++) {
            for (int j = i + 1; j < b; j++) {
                if (a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }
    private static void sum(int[]a,int num){
        int sum=0;
        for(int i=0;i<=num;i++){
            sum = sum+a[i];
        }
        System.out.printf("%d%n",sum);
    }
}




