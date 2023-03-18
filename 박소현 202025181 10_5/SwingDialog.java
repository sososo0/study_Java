package dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingDialog extends JDialog {

    JTextField jTextField = new JTextField(10);
    String m1 = "What was Dr.SEUSS's real last name?";
    String m2 = "(The answer is \"Hello\".)";
    Object [] arr = {m1,m2,jTextField};
    Object [] options = {"Enter","Cancel"};

    public SwingDialog(JFrame jFrame, String title){
        super(jFrame,title);
        setLayout(new FlowLayout());
        add(jTextField);
        this.setSize(400,200);
        JOptionPane optionPane = new JOptionPane(arr,JOptionPane.QUESTION_MESSAGE,JOptionPane.YES_NO_OPTION,null,options,options[0]);
        setContentPane(optionPane);

        jTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField t = (JTextField) e.getSource();
                if("Hello".equals(t.getText())){
                    setVisible(false);
                }
            }
        });
    }
}
