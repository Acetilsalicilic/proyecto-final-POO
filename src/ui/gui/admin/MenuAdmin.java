package ui.gui.admin;

import entidades.personas.empleados.Administrador;

import javax.swing.*;
import java.awt.*;

public class MenuAdmin extends JPanel {
    public static final String MENU_ADMIN = "menuAdmin";
    private JTabbedPane tab = new JTabbedPane();
    private MenuMembresias membresias = new MenuMembresias();
    private Administrador usuario;

    public MenuAdmin(Administrador usuario) {
        this.usuario = usuario;
        setLayout(new BorderLayout());
        tab.addTab("Membresías", membresias);

        add(tab, BorderLayout.CENTER);
        add(new JLabel("Usuario: "+usuario.getNombre()), BorderLayout.SOUTH);
    }
}
