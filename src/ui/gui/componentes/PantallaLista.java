package ui.gui.componentes;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class PantallaLista extends Pantalla {
    public PantallaLista(JTable tabla) {
        JScrollPane scrollTabla = new JScrollPane(tabla);
        addComponente(scrollTabla);
    }
}
