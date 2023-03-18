import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;

public class Task extends SwingWorker <Void,Void> {
    public Void doInBackground(){
        Random random = new Random();
        int progress =0;
        setProgress(0);

        while(progress < 100){
            try{
                Thread.sleep(random.nextInt(1000));
            }catch (InterruptedException e){}

                progress += random.nextInt(10);
                setProgress(Math.min(progress,100));

            }
            return null;
        }

        public void done(){
            Toolkit.getDefaultToolkit().beep();
            ProgressBarView.startButton.setEnabled(true);
            ProgressBarView.taskoutput.setCursor(null);
            ProgressBarView.taskoutput.append("Done!\n");
        }
    }

