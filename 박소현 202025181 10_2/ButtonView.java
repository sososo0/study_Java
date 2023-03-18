package button;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ButtonView extends JFrame implements ActionListener {
    JButton b1;
    JButton b2;
    JButton b3;

    public ButtonView(){
        this.setSize(3000,500);
        this.setLayout(new FlowLayout());

        b1 = new JButton("Disable middle button");
        b2 = new JButton("Middle button");
        b3 = new JButton("Enable middle button");

        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING);
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setActionCommand("disable");

        b2.setMnemonic(KeyEvent.VK_M);
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(b2,"dialog");
            }
        });

        b3.setMnemonic(KeyEvent.VK_E);
        b3.setActionCommand("enable");
        b3.setEnabled(false);

        b1.addActionListener(this);
        b3.addActionListener(this);

        b1.setToolTipText("Click this button to disable "+ "the middle button.");
        b3.setToolTipText("Click this button to enable the "+"middle button.");

        this.add(b1);
        this.add(b2);
        this.add(b3);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if("disable".equals(e.getActionCommand())){
            b2.setEnabled(false);
            b1.setEnabled(false);
            b3.setEnabled(true);
        }else{
            b2.setEnabled(true);
            b1.setEnabled(true);
            b3.setEnabled(false);
        }
    }
}
