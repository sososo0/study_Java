
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;

import java.nio.charset.StandardCharsets;


public class HttpServerTest{

    public static void main(String [] args){
        String HOSTNAME = "localhost";
        int PORT = 9000;
        int BACKLOG = 0;

        try{
            HttpServer server = HttpServer.create(new InetSocketAddress(HOSTNAME,PORT),BACKLOG);
            server.createContext("/hello", new HttpHandler() {
                @Override
                public void handle(HttpExchange exchange) throws IOException {
                    String responseBody = "hello world\n";
                    exchange.getResponseHeaders().add("Content-Type","application/json; UTF-8");
                    exchange.sendResponseHeaders(
                            HttpURLConnection.HTTP_OK,responseBody.getBytes(StandardCharsets.UTF_8).length);
                    OutputStream outputStream = exchange.getResponseBody();
                    outputStream.write(responseBody.getBytes(StandardCharsets.UTF_8));
                    outputStream.flush();
                    exchange.close();
                }
            });
            server.setExecutor(null);
            server.start();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
