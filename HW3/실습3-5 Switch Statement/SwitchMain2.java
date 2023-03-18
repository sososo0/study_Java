import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SwitchMain2 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        List<String> season = new ArrayList<>();

        while(true){
            String str = scanner.nextLine();

            if(str.equals("quit")){
                System.out.println("Bye");
                break;
            }

            String a;

            switch(str.toLowerCase()){
                case "print": System.out.println(season);
                break;
                case "add 1 ": a = "January"; season.add(a); break;
                case "add 2 ": a = "February"; season.add(a); break;
                case "add 3 ": a = "March"; season.add(a); break;
                case "add 4": a = "April"; season.add(a); break;
                case "add 5": a = "May"; season.add(a); break;
                case "add 6": a = "June"; season.add(a); break;
                case "add 7": a = "July"; season.add(a); break;
                case "add 8": a = "August"; season.add(a); break;
                case "add 8 ": a = "August"; season.add(a); break;
                case "add 9 ": a = "September"; season.add(a); break;
                case "add 10": a = "October"; season.add(a); break;
                case "add 11": a = "November"; season.add(a); break;
                case "add 12 ": a = "December"; season.add(a); break;
                default: System.out.println("Invalid Command"); break;
            }
        }
        scanner.close();
    }
}