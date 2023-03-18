package table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class SwingTableView extends JFrame implements ActionListener {

    JTable jTable;

    public SwingTableView(DefaultTableModel defaultTableModel) {
        Font font = new Font("Serif", Font.PLAIN, 24);
        jTable = new JTable(defaultTableModel);
        jTable.setModel(defaultTableModel);
        jTable.setRowHeight(24);
        jTable.getTableHeader().setFont(font);
        jTable.setPreferredScrollableViewportSize(new Dimension(800,150));

        JScrollPane scrollPane = new JScrollPane(jTable);
        final JButton jButton = new JButton("Info");
        jButton.setMnemonic(KeyEvent.VK_I);
        jButton.setAlignmentX(RIGHT_ALIGNMENT);
        jButton.setFont(font);
        jButton.addActionListener(this);
        jTable.setFillsViewportHeight(true);
        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        this.add(scrollPane);
        this.add(jButton);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(0<=jTable.getSelectedRow()){
            int numCols = jTable.getColumnCount();
            System.out.print(jTable.getSelectedRow());

            for(int i=0; i <numCols ; i++){
                System.out.print("\t\t\t"+jTable.getModel().getValueAt(jTable.getSelectedRow(),i));
            }
            System.out.println();
        }
    }

}
