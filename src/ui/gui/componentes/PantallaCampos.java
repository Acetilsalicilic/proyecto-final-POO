package ui.gui.componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class PantallaCampos extends Pantalla {
    protected JPanel filas = new JPanel();
    protected int ancho = 0;

    public PantallaCampos(int ancho) {
        this.ancho = ancho;

        filas.setLayout(new BoxLayout(filas, BoxLayout.Y_AXIS));
        filas.add(Box.createVerticalBox());
        addComponente(filas);
    }

    protected void addFila(JComponent... componentes) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        for (var c : componentes)
            panel.add(c);

        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel.getPreferredSize().height));
        filas.add(panel);
    }
    protected void addFila(String etiqueta, JComponent c) {
        addFila(new JLabel(etiqueta), c);
    }
}
