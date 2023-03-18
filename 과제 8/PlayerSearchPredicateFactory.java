package com.fm.repository;
import com.fm.game.SearchCondition;
import com.fm.unit.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class PlayerSearchPredicateFactory {
    public static List<Predicate<Player>> makeConditions(List<SearchCondition> searchConditions) {
        String [] a = new String[searchConditions.size()];

        for(int i=0;i<searchConditions.size();i++){
            a[i] = searchConditions.get(i).getField();
        }

        List<Predicate<Player>> predicates = new ArrayList<>();

        for (int i=0;i<searchConditions.size();i++){
            if("name".equals(a[i])){
                if(i==0){
                    Predicate<Player> n = player -> player.getName().contains(searchConditions.get(0).getCondition());
                    predicates.add(n);
                }
                else if(i==1){
                    Predicate<Player> n = player -> player.getName().contains(searchConditions.get(1).getCondition());
                    predicates.add(n);
                }
                else if(i==2){
                    Predicate<Player> n = player -> player.getName().contains(searchConditions.get(2).getCondition());
                    predicates.add(n);
                }
                else {
                    Predicate<Player> n = player -> player.getName().contains(searchConditions.get(3).getCondition());
                    predicates.add(n);
                }
            }
            if("club".equals(a[i])){
                if(i==0){
                    Predicate<Player> c = player -> player.getClub().contains(searchConditions.get(0).getCondition());
                    predicates.add(c);
                }
                else if(i==1){
                    Predicate<Player> c = player -> player.getClub().contains(searchConditions.get(1).getCondition());
                    predicates.add(c);
                }
                else if(i==2){
                    Predicate<Player> c = player -> player.getClub().contains(searchConditions.get(2).getCondition());
                    predicates.add(c);
                }
                else {
                    Predicate<Player> c = player -> player.getClub().contains(searchConditions.get(3).getCondition());
                    predicates.add(c);
                }
            }
            if("position".equals(a[i])){
                if(i==0){
                    Predicate<Player> p = player -> player.getPositions().contains(searchConditions.get(0).getCondition());
                    predicates.add(p);
                }
                else if(i==1){
                    Predicate<Player> p = player -> player.getPositions().contains(searchConditions.get(1).getCondition());
                    predicates.add(p);
                }
                else if(i==2){
                    Predicate<Player> p = player -> player.getPositions().contains(searchConditions.get(2).getCondition());
                    predicates.add(p);
                }
                else {
                    Predicate<Player> p = player -> player.getPositions().contains(searchConditions.get(3).getCondition());
                    predicates.add(p);
                }
            }
            if("nationality".equals(a[i])){
                if(i==0){
                    Predicate<Player> na = player -> player.getNationality().contains(searchConditions.get(0).getCondition());
                    predicates.add(na);
                }
                else if(i==1){
                    Predicate<Player> na = player -> player.getNationality().contains(searchConditions.get(1).getCondition());
                    predicates.add(na);
                }
                else if(i==2){
                    Predicate<Player> na = player -> player.getNationality().contains(searchConditions.get(2).getCondition());
                    predicates.add(na);
                }
                else {
                    Predicate<Player> na = player -> player.getNationality().contains(searchConditions.get(3).getCondition());
                    predicates.add(na);
                }
            }
        }
        return predicates;
    }

}

