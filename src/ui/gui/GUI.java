package ui.gui;

import javax.swing.*;

public class GUI {
    private JFrame frame;

    public GUI() {
        frame = new JFrame("Ventana");

        frame.add(new Login(
                () -> JOptionPane.showMessageDialog(frame, "OK!"),
                () -> JOptionPane.showMessageDialog(frame, "WRONG!")
        ));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 300, 500);
    }
    public void show() {
        frame.setVisible(true);
    }
}
