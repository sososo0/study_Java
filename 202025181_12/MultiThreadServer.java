package com.fm.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fm.server.SearchCondition;
import com.fm.server.model.PlayerRepository;
import com.fm.server.model.PlayerSearchPredicateFactory;
import com.fm.server.model.SearchPlayerModel;
import com.fm.unit.Player;
import com.sun.net.httpserver.HttpServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer {

    static String uri;

    public static void main(String [] args) {

        GUIView();

        HttpServer server;

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try {
            server = HttpServer.create(new InetSocketAddress("localhost", 9000), 0);
            server.createContext("/players", exchange -> {
                OutputStream outputStream = exchange.getResponseBody();
                if ("GET".equals(exchange.getRequestMethod())) {
                    sleep(1000);
                    String b = MultiThreadServer.uri;

                    String[] field = b.split("\\?", 2);
                    String[] conditionArr = field[1].split("&");

                    List<SearchCondition> conditions = new ArrayList<>();

                    for (int i = 0; i < conditionArr.length; i++) {
                        String[] conditionArr2 = conditionArr[i].split("=");
                        if (conditionArr2.length == 2) {
                            SearchCondition searchCondition = new SearchCondition(conditionArr2[0], conditionArr2[1]);
                            conditions.add(searchCondition);
                        }
                        if (conditionArr2.length == 4) {
                            SearchCondition searchCondition1 = new SearchCondition(conditionArr2[0], conditionArr2[1]);
                            conditions.add(searchCondition1);
                            SearchCondition searchCondition2 = new SearchCondition(conditionArr2[0], conditionArr2[1]);
                            conditions.add(searchCondition2);
                        }
                        if (conditionArr2.length == 6) {
                            SearchCondition searchCondition1 = new SearchCondition(conditionArr2[0], conditionArr2[1]);
                            conditions.add(searchCondition1);
                            SearchCondition searchCondition2 = new SearchCondition(conditionArr2[0], conditionArr2[1]);
                            conditions.add(searchCondition2);
                            SearchCondition searchCondition3 = new SearchCondition(conditionArr2[0], conditionArr2[1]);
                            conditions.add(searchCondition3);
                        }
                        if (conditionArr2.length == 8) {
                            SearchCondition searchCondition1 = new SearchCondition(conditionArr2[0], conditionArr2[1]);
                            conditions.add(searchCondition1);
                            SearchCondition searchCondition2 = new SearchCondition(conditionArr2[0], conditionArr2[1]);
                            conditions.add(searchCondition2);
                            SearchCondition searchCondition3 = new SearchCondition(conditionArr2[0], conditionArr2[1]);
                            conditions.add(searchCondition3);
                            SearchCondition searchCondition4 = new SearchCondition(conditionArr2[0], conditionArr2[1]);
                            conditions.add(searchCondition4);
                        }

                    }

                    List<Player> players = PlayerRepository.getInstance()
                            .query(PlayerSearchPredicateFactory.makeConditions(conditions));

                    String responseBody = players.toString();
                    exchange.getResponseHeaders().add("Content-Type", "text/html");
                    exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, responseBody.getBytes(StandardCharsets.UTF_8).length);
                    outputStream.write(responseBody.getBytes(StandardCharsets.UTF_8));
                    outputStream.flush();
                    System.out.println(Thread.currentThread().getName() + "-Done!");
                } else {
                    exchange.sendResponseHeaders(405, "not allowed".length());
                    outputStream.write("not allowed".getBytes());
                    outputStream.flush();
                }
                exchange.close();
            });

            server.setExecutor(null);
            server.setExecutor(executorService);
            server.start();

        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }

    public static void GUIView(){
        SearchPlayerModel model = new SearchPlayerModel();

        JFrame jFrame = new JFrame();
        jFrame.setTitle("Http URL");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel();
        JPanel jTot = new JPanel();
        JPanel jPanelB = new JPanel();
        JPanel jPanelT = new JPanel();

        JTextField jTextField1 = new JTextField(20);
        JTextField jTextField2 = new JTextField(20);
        JTextField jTextField3 = new JTextField(20);
        JTextField jTextField4 = new JTextField(20);

        JTextArea area = new JTextArea(5,40);

        JScrollPane jScrollPane = new JScrollPane(area);


        JLabel jLabel1 = new JLabel("name");
        JLabel jLabel2 = new JLabel("club");
        JLabel jLabel3 = new JLabel("position");
        JLabel jLabel4 = new JLabel("nationality");

        JButton jButton = new JButton("Submit");

        jButton.setActionCommand("submit");

        jFrame.setSize(200, 1000);
        jFrame.setLayout(new BorderLayout());
        jTot.setLayout(new BorderLayout());

        jPanel.setLayout(new GridLayout(4, 2));

        jTextField1.setSize(100, 20);
        jTextField2.setSize(100, 20);
        jTextField3.setSize(100, 20);
        jTextField4.setSize(100, 20);

        jPanel.add(jLabel1);
        jPanel.add(jTextField1);
        jPanel.add(jLabel2);
        jPanel.add(jTextField2);
        jPanel.add(jLabel3);
        jPanel.add(jTextField3);
        jPanel.add(jLabel4);
        jPanel.add(jTextField4);

        jTot.add(jPanel, BorderLayout.CENTER);

        jPanelB.add(jButton);

        jTot.add(jPanelB, BorderLayout.SOUTH);

        jPanelT.add(jScrollPane, BorderLayout.CENTER);

        jFrame.add(jTot, BorderLayout.NORTH);
        jFrame.add(jPanelT,BorderLayout.SOUTH);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("submit".equals(e.getActionCommand())) {

                    List<SearchCondition> conditions = new ArrayList<>();

                    if (!("".equals(jTextField1.getText()))) {
                        conditions.add(new SearchCondition("name", jTextField1.getText()));
                    }
                    if (!("".equals(jTextField2.getText()))) {
                        conditions.add(new SearchCondition("club", jTextField2.getText()));
                    }
                    if (!("".equals(jTextField3.getText()))) {
                        conditions.add(new SearchCondition("position", jTextField3.getText()));
                    }
                    if (!("".equals(jTextField4.getText()))) {
                        conditions.add(new SearchCondition("nationality", jTextField4.getText()));
                    }


                    area.setEditable(false);
                    area.append(GUILink(conditions).toString()+"\n\n");

                }
            }
        });

        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static List<Integer> GUILink(List<SearchCondition> list){

        List<SearchCondition> conditions = list;

        String urlBase = "http://localhost:9000/players?";
        String url = "";

        for(int i=0;i<conditions.size();i++){
            if(conditions.size()== 1){
                urlBase = urlBase + conditions.get(0).getField() +"="+conditions.get(0).getCondition();
            }else if(conditions.size() == 2){
                urlBase = urlBase + conditions.get(0).getField() +"="+conditions.get(0).getCondition()
                        +"&"+ conditions.get(1).getField() +"="+conditions.get(1).getCondition();
            }else if(conditions.size() == 3){
                urlBase = urlBase + conditions.get(0).getField() +"="+conditions.get(0).getCondition()
                        +"&"+ conditions.get(1).getField() +"="+conditions.get(1).getCondition()
                        +"&"+ conditions.get(2).getField() +"="+conditions.get(2).getCondition();
            }else {
                urlBase = urlBase + conditions.get(0).getField() +"="+conditions.get(0).getCondition()
                        +"&"+ conditions.get(1).getField() +"=" +conditions.get(1).getCondition()
                        +"&"+ conditions.get(2).getField() +"="+conditions.get(2).getCondition()
                        +"&"+ conditions.get(3).getField()+"="+conditions.get(3).getCondition();
            }
        }

        url = urlBase;

        uri = url;


        ObjectMapper mapper = new ObjectMapper();

        try{
            HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();
            String result = client.sendAsync(
                            HttpRequest.newBuilder(new URI(url)).GET().build(), HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body).get();


            CollectionType playerListType = mapper.getTypeFactory().constructCollectionType(java.util.List.class, Integer.class);

            List<Integer> playerList = mapper.readValue(result, playerListType);

            return playerList;

        }catch (JsonProcessingException e){
            List<Integer> players = new ArrayList<>();
            e.printStackTrace();
            return players;
        }catch (URISyntaxException e){
            List<Integer> players = new ArrayList<>();
            e.printStackTrace();
            return players;
        }
        catch (InterruptedException e){
            List<Integer> players = new ArrayList<>();
            e.printStackTrace();
            return players;
        }catch (ExecutionException e) {
            List<Integer> players = new ArrayList<>();
            e.printStackTrace();
            return players;
        }

    }
}



