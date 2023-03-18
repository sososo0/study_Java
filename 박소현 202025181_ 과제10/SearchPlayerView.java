package com.fm.view;
import com.fm.controller.CreatePlayerDialog;
import com.fm.controller.SearchPlayerController;
import com.fm.model.SearchPlayerModel;
import com.fm.repository.PlayerRepository;
import com.fm.unit.Player;
import org.w3c.dom.events.MouseEvent;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class SearchPlayerView extends JFrame {

    JFrame jFrame = new JFrame();
    JPanel jPanel = new JPanel();
    JPanel jPanelB = new JPanel();
    JPanel jTot = new JPanel();

    JTextField j1 = new JTextField(20);
    JTextField j2 = new JTextField(20);
    JTextField j3 = new JTextField(20);
    JTextField j4 = new JTextField(20);

    JTextField [] arr ={j1,j2,j3,j4};

    JLabel jl1 = new JLabel("name");
    JLabel jl2 = new JLabel("club");
    JLabel jl3 = new JLabel("position");
    JLabel jl4 = new JLabel("nationality");

    JButton jb1 = new JButton("Create");
    JButton jb2 = new JButton("Delete");
    JButton jb3 = new JButton("Search");

    Vector<String> colName = new Vector<>();

    JTable jt;
    JScrollPane jp;

    public SearchPlayerView(SearchPlayerController controller, SearchPlayerModel model) {

        jFrame.setSize(600,1000);
        jFrame.setLayout(new BorderLayout());
        jTot.setLayout(new BorderLayout());
        jPanel.setLayout(new GridLayout(4,2));
        j1.setSize(500,20);
        j2.setSize(500,20);
        j3.setSize(500,20);
        j4.setSize(500,20);
        jPanel.add(jl1);
        jPanel.add(j1);
        jPanel.add(jl2);
        jPanel.add(j2);
        jPanel.add(jl3);
        jPanel.add(j3);
        jPanel.add(jl4);
        jPanel.add(j4);
        jTot.add(jPanel,BorderLayout.CENTER);

        jPanelB.add(jb1);
        jPanelB.add(jb2);
        jPanelB.add(jb3);

        jTot.add(jPanelB,BorderLayout.SOUTH);

        for(int i=0;i<model.getColumnCount();i++){
            colName.add(model.getColumnName(i));
        }

        jt = new JTable(model.getDataVector(),colName);
        jp = new JScrollPane(jt);
        jFrame.add(jTot,BorderLayout.NORTH);
        jFrame.add(jp,BorderLayout.CENTER);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dialog dialog = new CreatePlayerDialog(PlayerRepository.getInstance(), model);
                dialog.setVisible(true);
            }
        });

        jb2.addActionListener(new DeletePlayerActionListener(jt,controller));

        jb3.addActionListener(new SearchPlayerActionListener(arr,controller,model));

    }


}