package dialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingDialogView extends JFrame{
    SwingDialog dialog;

    public SwingDialogView(){
        JButton jButton = new JButton("Show");
        dialog = new SwingDialog(this,"Quiz");

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        });
        this.add(jButton);
        this.setSize(600,400);
    }
}
