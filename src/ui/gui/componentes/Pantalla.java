package ui.gui.componentes;

import javax.swing.*;
import java.awt.*;

public abstract class Pantalla extends JPanel {
    private JScrollPane scroll;
    private JPanel card = new JPanel();
    protected static final String PRINCIPAL = "principal";
    protected JPanel contenedor = new JPanel();
    protected CardLayout cardLayout;
    public Pantalla() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        card.setLayout(new BorderLayout());
        add(card, PRINCIPAL);

        scroll = new JScrollPane(contenedor);
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
        card.add(scroll, BorderLayout.CENTER);
    }
    protected void addComponente(JComponent p) {
        contenedor.add(p);
    }
    protected void addCard(JPanel p, String etiqueta) {
        add(p, etiqueta);
    }
}
