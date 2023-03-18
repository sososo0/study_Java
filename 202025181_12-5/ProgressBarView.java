import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ProgressBarView extends JPanel implements ActionListener, PropertyChangeListener {

    public static JProgressBar progressBar ;
    public static JButton startButton;
    public static JTextArea taskoutput;
    private Task task;

    public ProgressBarView(){
        super(new BorderLayout());
        startButton = new JButton("Start");
        startButton.setActionCommand("start");
        startButton.addActionListener(this);

        progressBar = new JProgressBar(0,100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        taskoutput = new JTextArea(5,20);
        taskoutput.setMargin(new Insets(5,5,5,5));
        taskoutput.setEditable(false);

        JPanel panel = new JPanel();

        panel.add(startButton);
        panel.add(progressBar);
        add(panel, BorderLayout.PAGE_START);
        add(new JScrollPane(taskoutput),BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    }

    public void actionPerformed(ActionEvent e){
        startButton.setEnabled(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        task = new Task();
        task.addPropertyChangeListener(this);
        task.execute();
    }

    public void propertyChange(PropertyChangeEvent e){
        if("progress".equals(e.getPropertyName())){
            int progress = (Integer) e.getNewValue();
            progressBar.setValue(progress);
            taskoutput.append(String.format("Completed %d%% of task.\n",task.getProgress()));
        }
    }

}
