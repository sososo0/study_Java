import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class StringCompareMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            String str = scanner.nextLine();
            stringList.add(str);
        }
        scanner.close();

        String str1 = stringList.get(0);
        String str2 = stringList.get(1);

        boolean s;

        s = str1.equals(str2);
        System.out.println(s);
        s = str1.equalsIgnoreCase(str2);
        System.out.println(s);
        s = str1.equals(str2.toLowerCase(Locale.ROOT));
        System.out.println(s);

        String a = "easy";
        String b = "fun";
        if (str1.indexOf(a) > 0) {
            String str3 = str1.replace(a,b);
            s = str3.equalsIgnoreCase(str2);
            System.out.println(s);
        } else {
            s = str1.equalsIgnoreCase(str2);
            System.out.println(s);
        }
    }
}
