package com.fm.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fm.unit.Player;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;


public class PlayerClient {
    public static void main (String [] args){
        String urlBase = "http://localhost:9000/players?";
        String url = "";

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            String option = scanner.nextLine();
            String [] params = option.split(" ");
            if(params.length == 2){
                urlBase = urlBase + params[0] +"="+params[1];
            }else if(params.length == 4){
                urlBase = urlBase + params[0] +"="+params[1]+"&"+ params[2] +"="+params[3];
            }else if(params.length == 6){
                urlBase = urlBase + params[0] +"="+params[1]+"&"+ params[2] +"="+params[3]+"&"+ params[4] +"="+params[5];
            }else {
                urlBase = urlBase + params[0] +"="+params[1]+"&"+ params[2] +"="+params[3]+"&"+ params[4] +"="+params[5]
                        +"&"+ params[6] +"="+params[7];
            }
        }
        scanner.close();

        url = urlBase;

        ObjectMapper mapper = new ObjectMapper();

        try{
            HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();
            String result = client.sendAsync(
                    HttpRequest.newBuilder(
                            new URI(url)).GET().build(),HttpResponse.BodyHandlers.ofString()
            ).thenApply(HttpResponse::body).get();

            CollectionType playerListType = mapper.getTypeFactory().constructCollectionType(List.class, Player.class);

            List<Player> playerList = mapper.readValue(result, playerListType);

            System.out.printf("%s\n",playerList);

        }catch (JsonProcessingException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (URISyntaxException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }

    }
    }


