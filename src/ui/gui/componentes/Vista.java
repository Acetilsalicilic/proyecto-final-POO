package ui.gui.componentes;

import entidades.personas.Persona;

import javax.swing.*;
import java.awt.*;

public abstract class Vista extends JPanel {
    protected JPanel container = new JPanel();
    protected JTabbedPane tabs = new JTabbedPane();
    protected Persona persona;
    public Vista(String tipoVista, Persona persona) {
        this.persona = persona;
        setLayout(new BorderLayout());

        container.setLayout(new BorderLayout());

        container.add(new JLabel("Vista "+tipoVista), BorderLayout.NORTH);
        container.add(new JLabel("Usuario: "+persona.getNombre()), BorderLayout.SOUTH);
        container.add(tabs, BorderLayout.CENTER);

        add(container, BorderLayout.CENTER);
    }
}
