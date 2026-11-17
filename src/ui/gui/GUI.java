package ui.gui;

import entidades.personas.Persona;
import entidades.personas.empleados.Administrador;
import ui.gui.admin.MenuAdmin;
import ui.gui.admin.MenuMembresias;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class GUI {
    private JFrame frame;
    private JPanel main = new JPanel();

    public static Font TITLE_FONT = new Font("Adwaita Sans", Font.PLAIN, 30);

    private static final String LOGIN = "login";

    public GUI() {
        frame = new JFrame("Ventana");
        main.setLayout(new CardLayout());
        frame.add(main);

        Consumer<Persona> onSuccesful = persona -> {
            JOptionPane.showMessageDialog(frame, "OK! Bienvenid@, "+persona.getNombre());
            switch (persona) {
                case Administrador adm -> {
                    main.add(new MenuAdmin(adm), MenuAdmin.MENU_ADMIN);
                    ((CardLayout) main.getLayout()).show(main, MenuAdmin.MENU_ADMIN);
                }
                default -> throw new IllegalArgumentException("Tipo de usuario desconocido en LOGIN");
            }
        };

        main.add(new Login(
                onSuccesful,
                () -> JOptionPane.showMessageDialog(frame, "WRONG!")
        ), LOGIN);

        // Configure the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 700, 900);
    }
    public void show() {
        frame.setVisible(true);
    }
}
