package ui.gui.componentes;

import javax.swing.*;

public class PantallaCampos extends Pantalla {
    public PantallaCampos(String titulo) {
        addContenedor(new JLabel(titulo));
    }
}
