package ui.gui.componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class PantallaCampos extends Pantalla {
    private Map<String, JTextField> campos = new HashMap<>();
    private JPanel filas = new JPanel();

    public PantallaCampos() {
        filas.setLayout(new BoxLayout(filas, BoxLayout.Y_AXIS));
        filas.add(Box.createVerticalBox());
        addComponente(filas);
    }

    public PantallaCampos(Consumer<Map<String, String>> handler, String etiquetaBoton, int ancho, String... titulos) {
        this();

        // Añadir las filas
        for (var titulo : titulos) {
            campos.put(titulo, new JTextField(ancho));
            addFila(new JLabel(titulo), campos.get(titulo));
        }

        JButton boton = new JButton(etiquetaBoton);
        boton.addActionListener(evt -> {
            Map<String, String> texto = new HashMap<>();

            for (var titulo : campos.keySet()) {
                texto.put(titulo, campos.get(titulo).getText());
            }

            handler.accept(texto);
        });
        addFila(boton);
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
}
