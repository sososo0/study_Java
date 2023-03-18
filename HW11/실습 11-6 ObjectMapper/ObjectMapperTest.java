import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Scanner;

public class ObjectMapperTest {
    public static void main(final String... args) throws IOException {
        ObjectMapper obm = new ObjectMapper();
        Scanner sc = new Scanner(System.in);
        Player player = new Player(sc.nextInt(), sc.next());
        String responseBody = "";
        try {
            responseBody = obm.writeValueAsString(player); // your code here //
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(responseBody);
        String jsonStr = "{\"id\":"+player.getId()+",\"name\":\""+player.getName()+"\"}";
        player = obm.readValue(jsonStr,Player.class); // your code here //
        System.out.println(player);
    }
}
