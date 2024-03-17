package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToDoWindow extends JDialog implements ActionListener{

    List<Job> todoLists = CheckList.getInstance().getAllJob();
    JTextField textField;
    JButton button;
    JButton closeButton;
//    private  String line;

    ToDoWindow() {
        button = new JButton();
        button.setText("Submit");
        button.setMaximumSize(new Dimension(50,50));
        button.setMinimumSize(new Dimension(50,50));
        button.addActionListener(this);

        closeButton = new JButton("Close");
        closeButton.addActionListener(e -> this.dispose());

        textField = new JTextField("", 25);
        textField.setMinimumSize(new Dimension(500, 10));
        textField.setMaximumSize(new Dimension(500, 10));
        textField.setFont(new Font("Consolas", Font.PLAIN, 10));
        textField.setText("Type here");

        JPanel panel = new JPanel();
        panel.setSize(new Dimension(500, 500));
        panel.add(textField);
        panel.add(button);
        panel.add(closeButton);

        this.setContentPane(panel);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setMinimumSize(new Dimension(350, 150));
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            Job todo = new Job(textField.getText());
            todoLists.add(todo);
            textField.setText("");
        }
    }
}
