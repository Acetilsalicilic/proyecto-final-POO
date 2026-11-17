package ui.gui.componentes;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class PantallaLista extends Pantalla {
    private final AbstractTableModel model;
    public PantallaLista(AbstractTableModel model) {
        this.model = model;
        JScrollPane scrollTabla = new JScrollPane(new JTable(model));
        addContenedor(scrollTabla);
    }
}
