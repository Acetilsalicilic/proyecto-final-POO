package ui.gui.componentes;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class PantallaCampos extends Pantalla {
    protected JPanel filas = new JPanel();
    protected int ancho = 0;
    protected Map<String, JComponent> componentes = new HashMap<>();

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

        for (var c : componentes) {
            panel.add(c);
        }

        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel.getPreferredSize().height));
        filas.add(panel);

    }
    protected void addFila(String etiqueta, JComponent c) {
        addFila(new JLabel(etiqueta), c);
        componentes.put(etiqueta, c);
    }
    protected void addBoton(String etiqueta, Runnable enBotonPresionado) {
        var boton = new JButton(etiqueta);
        boton.addActionListener(evt -> {
            enBotonPresionado.run();
            limpiarCampos();
        });
        addFila(etiqueta, boton);
    }
    protected void limpiarCampos() {
        for (var c : componentes.values()) {
            switch (c) {
                case JTextField t -> t.setText("");
                case JCheckBox ch -> ch.setSelected(false);
                case JButton _ -> {} // No hacer nada
                case JComboBox _ -> {} // No hacer nada
                default -> throw new IllegalArgumentException("Tipo de componente desconocido");
            }
        }
    }
    protected void addCampoTexto(String etiqueta) {
        JTextField campo = new JTextField(ancho);
        componentes.put(etiqueta, campo);
        addFila(etiqueta, campo);
    }
    protected void addCheck(String etiqueta) {
        JCheckBox campo = new JCheckBox();
        componentes.put(etiqueta, campo);
        addFila(etiqueta, campo);
    }
    protected JComponent get(String etiqueta) {
        return componentes.getOrDefault(etiqueta, null);
    }
}
