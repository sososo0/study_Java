import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpResponse.BodyHandlers.ofString;

public class HttpClientTest {
    public static Object get(String url){

        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse response = client.send(request,ofString());
            return response.body();
        }catch (InterruptedException e){
            return e;
        }catch (IOException e){
            return e;
        }
    }

    public static void main(String [] args){
        Object a = HttpClientTest.get("https://httpbin.org/ip");
        System.out.println(a);
    }
}

