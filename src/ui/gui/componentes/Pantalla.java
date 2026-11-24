package ui.gui.componentes;

import javax.swing.*;
import java.awt.*;

public abstract class Pantalla extends JPanel {
    protected static final String PRINCIPAL = "principal";

    private JScrollPane scroll;

    protected JPanel contenedor = new JPanel();
    protected CardLayout cardLayout;

    public Pantalla() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        JPanel cartaPrincipal = new JPanel();
        cartaPrincipal.setLayout(new BorderLayout());
        add(cartaPrincipal, PRINCIPAL);

        scroll = new JScrollPane(contenedor);
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));

        cartaPrincipal.add(scroll, BorderLayout.CENTER);
    }
    protected void addComponente(JComponent p) {
        contenedor.add(p);
    }

    protected void addCard(JPanel p, String etiqueta) {
        add(p, etiqueta);
    }
}
