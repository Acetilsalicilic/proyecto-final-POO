package ui.gui.componentes;

import javax.swing.*;
import java.awt.*;

public abstract class Pantalla extends JPanel {
    private JScrollPane scroll;
    protected JPanel contenedor = new JPanel();
    public Pantalla() {
        setLayout(new BorderLayout());
        scroll = new JScrollPane(contenedor);
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
        add(scroll, BorderLayout.CENTER);
    }
    protected void addComponente(JComponent p) {
        contenedor.add(p);
    }
}
