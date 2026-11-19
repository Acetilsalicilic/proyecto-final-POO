package ui.gui.componentes;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PantallaCampos extends Pantalla {
    protected JPanel filas = new JPanel();
    protected int ancho = 0;

    protected Map<String, JTextField> camposTexto = new HashMap<>();
    protected Map<String, JCheckBox> camposCheck = new HashMap<>();

    // TODO analizar que hacer con el ancho. Podría desaparecer si se unsa GridBagLayout?
    public PantallaCampos(int ancho) {
        this.ancho = ancho;

        filas.setLayout(new BoxLayout(filas, BoxLayout.Y_AXIS));
        filas.add(Box.createVerticalBox());
        addComponente(filas);
    }

    // TODO analizar si de verdad hacen falta tantos métodos distintos para añadir filas
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

        if (c instanceof JTextField t)
            camposTexto.put(etiqueta, t);
        else if (c instanceof JCheckBox t)
            camposCheck.put(etiqueta, t);
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
        for (var t : camposTexto.values())
            t.setText("");

        for (var c : camposCheck.values())
            c.setSelected(false);
    }
    protected void setTextoCampo(String etiqueta, String texto) {
        if (!camposTexto.containsKey(etiqueta))
            throw new IllegalStateException("No existe el campo con la etiqueta: "+etiqueta);
        camposTexto.get(etiqueta).setText(texto);
    }
    protected void setTextoCampo(String etiqueta, Object texto) {
        setTextoCampo(etiqueta, texto.toString());
    }
    protected void addCampoTexto(String etiqueta) {
        JTextField campo = new JTextField(ancho);
        camposTexto.put(etiqueta, campo);
        addFila(etiqueta, campo);
    }
    protected void addCheck(String etiqueta) {
        JCheckBox campo = new JCheckBox();
        camposCheck.put(etiqueta, campo);
        addFila(etiqueta, campo);
    }
    protected JTextField getCampoTexto(String etiqueta) {
        if (!camposTexto.containsKey(etiqueta))
            throw new IllegalStateException("No existe el campo con la etiqueta");

        return camposTexto.get(etiqueta);
    }
    protected JCheckBox getCheckBox(String etiqueta) {
        if (!camposCheck.containsKey(etiqueta))
            throw new IllegalStateException("No existe el campo con la etiqueta");

        return camposCheck.get(etiqueta);
    }
}
