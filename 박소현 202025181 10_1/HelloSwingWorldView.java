package helloworld;
import javax.swing.*;

public class HelloSwingWorldView extends JFrame{
  JFrame jFrame = new JFrame();
  JLabel jLabel = new JLabel("Hello World");

  public HelloSwingWorldView(){
      this.setSize(600,300);
      this.add(jLabel);
  }
}
