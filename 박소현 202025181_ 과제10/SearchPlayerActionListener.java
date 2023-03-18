package com.fm.view;
import com.fm.controller.SearchPlayerController;
import com.fm.model.SearchPlayerModel;
import com.fm.repository.PlayerRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class SearchPlayerActionListener implements ActionListener {
    private JTextField[] searchTermTextFields;
    private SearchPlayerController controller;
    private SearchPlayerModel m;

    public SearchPlayerActionListener(JTextField[] searchTermTextFields, SearchPlayerController controller,SearchPlayerModel m) {
        super();
        this.searchTermTextFields = searchTermTextFields;
        this.controller = controller;
        this.m = m;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // your code here

        List<SearchCondition> conditions = new ArrayList<>();

        if(!("".equals(searchTermTextFields[0].getText()))){
            conditions.add(new SearchCondition("name",searchTermTextFields[0].getText()));
        }
        if(!("".equals(searchTermTextFields[1].getText()))){
            conditions.add(new SearchCondition("club",searchTermTextFields[1].getText()));
        }
        if(!("".equals(searchTermTextFields[2].getText()))){
            conditions.add(new SearchCondition("position",searchTermTextFields[2].getText()));
        }
        if(!("".equals(searchTermTextFields[3].getText()))){
            conditions.add(new SearchCondition("nationality",searchTermTextFields[3].getText()));
        }

        controller.searchPlayer(conditions,m);
    }

    }

