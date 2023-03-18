import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateMain{
    public static void main(String[] args){

        final Date n = new Date();

        final SimpleDateFormat f1 = new SimpleDateFormat("yyyy년 MM월 dd일");
        final SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final SimpleDateFormat f3 = new SimpleDateFormat("오늘은 이 달의 W번째 E요일 입니다.", Locale.KOREA);

        System.out.println(f1.format(n));
        System.out.println(f2.format(n));
        System.out.println(f3.format(n));
    }
}