package Gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WindowCloseListener implements WindowListener {
    List<Job> todoLists = CheckList.getInstance().getAllJob();

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

        writeFile();

    }

    @Override
    public void windowClosed(WindowEvent e) {

        writeFile();

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
    public void writeFile() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("checklist2.csv");
            for (Job job : todoLists)
                fw.write(job.getLine()+ "," + job.isFinished + "\n");
            fw.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
