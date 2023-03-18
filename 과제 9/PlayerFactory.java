package com.fm.repository;

import com.fm.unit.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerFactory {
    public static Player createPlayersWithoutID(String[] fields) {
        List<String> positions = new ArrayList<>();
        if (fields[5].startsWith("\"")) {
            for (int i = 5; i < fields.length; i++)
                positions.add(fields[i].replace("\"", "").trim());
        } else {
            positions.add(fields[5]);
        }

        Player player = new Player(fields[0], Integer.parseInt(fields[1]), fields[2], fields[3], Integer.parseInt(fields[4]), positions);

        return player;
    }

    public static Player createPlayers(String[] fields) {

        List<String> positions = new ArrayList<>();
        if (fields[6].startsWith("\"")) {
            for (int i = 6; i < fields.length; i++)
                positions.add(fields[i].replace("\"", "").trim());
        } else {
            positions.add(fields[6]);
        }

        Player player = new Player(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]), fields[3], fields[4], Integer.parseInt(fields[5]), positions);

        return player;
    }
}
