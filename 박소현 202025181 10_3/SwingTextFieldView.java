package textfield;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingTextFieldView extends JFrame{

    JTextField jTextField = new JTextField(20);
    JTextArea jTextArea = new JTextArea(5,20);
    JButton jButton = new JButton("Enter");

    public SwingTextFieldView(){

        this.setLayout(new FlowLayout());
        this.setSize(400,300);
        this.add(jTextField);
        this.add(jButton);
        this.add(new JScrollPane(jTextArea));
        jTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField t = (JTextField) e.getSource();
                jTextArea.append(t.getText() + "\n");
                t.setText("");
            }
        });

    }
}
