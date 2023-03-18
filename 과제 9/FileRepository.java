package com.fm.repository;

import com.fm.unit.Player;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FileRepository implements IRepository {
    public static final String[] FILE_HEADER =
            {"sofifa_id", "short_name", "height_cm", "nationality", "club", "overall", "player_positions", "\n"};
    private static FileRepository instance = new FileRepository();
    public final String FILENAME =
            Thread.currentThread().getContextClassLoader().getResource("players_20_short.csv").getFile();
    private boolean loaded = false;
    private List<Player> players = new ArrayList<>();

    private FileRepository() {
        load();
    }

    public static FileRepository getInstance() {
        return instance;
    }

    private Player create(String[] fields) {
        return PlayerFactory.createPlayers(fields);
    }
    //your code here


    public List<Player> load() {
        if (!isLoaded()) {

            Path path = Paths.get(FILENAME);
            BufferedReader br = null;

            try{
                br = Files.newBufferedReader(path);

                String line = "";

                while ((line=br.readLine())!= null) {
                    String[] a = line.split(",");
                    if(a[0].equals(FILE_HEADER[0])){continue;}
                    Player player = create(a);
                    players.add(player);
                }


                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return players;
    }

    public boolean isLoaded(){return loaded;}

    public int count() {
        return players.size();
    }

    public void save(Player t) {

        players.add(t);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME,true));

            String result = t.getPositions().stream().map(String::toString).collect(Collectors.joining());
            bw.write(Integer.toString(t.getId()));
            bw.write(",");
            bw.write(t.getName());
            bw.write(",");
            bw.write(Integer.toString(t.getHeight()));
            bw.write(",");
            bw.write(t.getNationality());
            bw.write(",");
            bw.write(t.getClub());
            bw.write(",");
            bw.write(Integer.toString(t.getOverall()));
            bw.write(",");
            bw.write(result);

            bw.flush();

            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void delete(Player t) {
        players.remove(t);
        Path path = Paths.get(FILENAME);
        try {
            BufferedWriter bw= Files.newBufferedWriter(path);

            for(int i=0; i<players.size();i++) {
                String result = players.get(i).getPositions().stream().map(String::toString).collect(Collectors.joining());
                bw.write(Integer.toString(players.get(i).getId()));
                bw.write(",");
                bw.write(players.get(i).getName());
                bw.write(",");
                bw.write(Integer.toString(players.get(i).getHeight()));
                bw.write(",");
                bw.write(players.get(i).getNationality());
                bw.write(",");
                bw.write(players.get(i).getClub());
                bw.write(",");
                bw.write(Integer.toString(players.get(i).getOverall()));
                bw.write(",");
                bw.write("\"");
                for(int j=0;j<players.get(i).getPositions().size();j++) {
                    bw.write(players.get(i).getPositions().get(j));
                    if(j==players.get(i).getPositions().size()-1)
                        break;
                    bw.write(",");
                }
                bw.write("\"");
                bw.newLine();
            }
            bw.flush();

            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        if (findById(id).isPresent()) {
            Player player = findById(id).get();
            players.remove(player);
        }
    }

    public boolean existsById(int id) {
        if (findById(id).isPresent()) {
            return true;
        } else return false;
    }

    public Iterable<Player> findAll() {
        return players;
    }

    public Optional<Player> findById(int id) {
        Player player0 = players.stream().filter(player1 -> id == player1.getId()).collect(Collectors.toList()).get(0);
        Optional<Player> player = Optional.ofNullable(player0);
        return player;
    }

    public List<Player> findByConditions(List<Predicate<Player>> conditions) {
        if (0 < conditions.size() && 0 < players.size())
            return PlayerQuery.query(players, conditions);
        else
            return new ArrayList<>();
    }

    }

