package Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyFrame extends JFrame implements ActionListener {
    ListWindow listWindow = ListWindow.getInstance();
    JButton addButton;
    JButton viewButton;
    JFrame frame = new JFrame();
    public MyFrame() throws IOException {
        addButton = new JButton("Add to List");
        addButton.setBounds(50,100,100,50);
        addButton.addActionListener(this);

        viewButton = new JButton("View List");
        viewButton.setBounds(150,100,100,50);
        viewButton.addActionListener(this);

        frame.add(addButton);
        frame.add(viewButton);
        frame.setTitle("ToDo Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setLayout(null);
        frame.addWindowListener(new WindowCloseListener());
        frame.setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addButton) {
            ToDoWindow addList = new ToDoWindow();
    }
        else if(e.getSource()==viewButton) {
            try {
                 listWindow.showWindow();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
