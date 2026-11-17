package ui.gui.componentes;

import ui.gui.GUI;

import javax.swing.*;

public class PantallaSplash extends Pantalla {
    public PantallaSplash(String titulo) {
        var titulo_l = new JLabel(titulo);
        titulo_l.setFont(GUI.FUENTE_TITULO);
        addComponente(titulo_l);
    }
}
