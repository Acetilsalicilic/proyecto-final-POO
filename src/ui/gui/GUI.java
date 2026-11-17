package ui.gui;

import entidades.personas.Persona;
import entidades.personas.empleados.Administrador;
import ui.gui.admin.VistaAdmin;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class GUI {
    public static final Font FUENTE_TITULO = new Font("Adwaita Sans", Font.PLAIN, 30);

    private JFrame frame;
    private JPanel main = new JPanel();
    public GUI() {
        frame = new JFrame("Sistema GYM");
        main.setLayout(new CardLayout());
        frame.add(main);

        //main.add(new VistaAdmin(new Administrador("admin")), BorderLayout.CENTER);

        Consumer<Persona> enExito = persona -> {
            switch (persona) {
                case Administrador adm -> {
                    main.add(new VistaAdmin(adm), "vistaAdmin");
                    var mgr = (CardLayout) main.getLayout();
                    mgr.show(main, "vistaAdmin");
                }
                default -> throw new IllegalArgumentException("Tipo de persona desconocido");
            }
        };

        main.add(new Login(enExito, () -> JOptionPane.showMessageDialog(frame, "ERROR!")), "login");

        // Configurar la ventana
        frame.setBounds(200, 200, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void show() {
        frame.setVisible(true);
    }
}
