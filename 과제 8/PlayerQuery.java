package com.fm.repository;
import com.fm.unit.Player;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PlayerQuery {
    public static List<Player> query(List<Player> players, List<Predicate<Player>> conditions) {

        if(conditions.size()==1){
            List<Player> playerList = players.stream().filter(player -> conditions.get(0).test(player)).collect(Collectors.toList());
            return playerList;
        }
        if(conditions.size()==2){
            Predicate<Player> playerPredicate = conditions.get(0).and(conditions.get(1));
            List<Player> playerList = players.stream().filter(playerPredicate).collect(Collectors.toList());
            return playerList;
        }
        if(conditions.size() == 3){
            List<Player> playerList = players.stream().filter(conditions.get(0)).filter(conditions.get(1)).filter(conditions.get(2)).collect(Collectors.toList());
            return playerList;
        }
        else{
            List<Player> playerList = players.stream().filter(conditions.get(0)).filter(conditions.get(1)).filter(conditions.get(2)).filter(conditions.get(3)).collect(Collectors.toList());
            return playerList;
        }
    }

    }

