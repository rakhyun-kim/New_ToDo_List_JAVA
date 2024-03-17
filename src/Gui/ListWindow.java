package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListWindow extends JDialog implements ActionListener {
    private static ListWindow listWindow = null;
    public static ListWindow getInstance() throws IOException {
        if (listWindow == null) {
            listWindow = new ListWindow();
        }
        return listWindow;
    }
    List<JCheckBox> checkBoxes = new ArrayList<>();
    FileReader fr = new FileReader("checklist2.csv");
    JButton button;
    JCheckBox checkBox;
    CheckList cl = CheckList.getInstance();
    Boolean window = false;
    JPanel panel;

    private ListWindow() throws IOException {

        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        int i = 0; // A`s
        if (window == false) {
            while (line != null) {
//                Job job = new Job(line);
                String[] jobs = line.split(","); //TODO: Don't forget to set status for job
                Job readJob = new Job(jobs[0], Boolean.valueOf(jobs[1]));
                cl.addJob(readJob);
                line = br.readLine();
                i++; //A`s
            }
            br.close();

            button = new JButton();
            button.setText("Delete");
            button.setMinimumSize(new Dimension(50, 50));
            button.addActionListener(this);

            panel = new JPanel();
            panel.setSize(new Dimension(500, 500));
            panel.add(button);

        }
        window = true;
    }
    public void showWindow() throws IOException {
        for (Job job : cl.getOngoingJobs()) {
            boolean addCheckBox = true;
            for (JCheckBox checkJob : checkBoxes) {
                if (checkJob.getText().equals(job.getLine())) {
                    addCheckBox = false;
                    break;
                }
            }
            if(addCheckBox) {
                checkBox = new JCheckBox();
                checkBox.setText(job.getLine()); // Test line done
                panel.add(checkBox);
                checkBoxes.add(checkBox);
            }
        }

        this.setContentPane(panel);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setMinimumSize(new Dimension(350, 500));
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            for (int i = checkBoxes.size() - 1; i >= 0; i--) {
                JCheckBox checkBox = checkBoxes.get(i);
                if (checkBox.isSelected()) {
                    cl.changeJobStatusByLine(checkBox.getText());
                    panel.remove(checkBox);
                    checkBoxes.remove(i);
                }
            }
            panel.revalidate();
            panel.repaint();
        }
    }
}
//          if (e.getSource() == button) {
////              for (JCheckBox jCheckBox : checkBoxes) {
////                  if ( jCheckBox.isSelected()) { //(2) Define the logic WITH the object at the index
////                        this.remove(jCheckBox);
////                        checkBoxes.remove(jCheckBox); //(3) Perform what you want
////                 }
////              }
//             for (int i=0; i<checkBoxes.size(); i++) { //Whenever you are looping with a list
//                 JCheckBox jCheckBox = checkBoxes.get(i); // (1) Always get with the index
//                 if ( jCheckBox.isSelected()) { //(2) Define the logic WITH the object at the index
//                        this.remove(jCheckBox);
//                        checkBoxes.remove(jCheckBox); //(3) Perform what you want
//                 }
//             }
//          }
//          this.revalidate(); //Not a logic thing, not too important. Just GUI method to 'refresh' screen
//          this.repaint();
