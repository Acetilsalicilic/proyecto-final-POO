package ui.gui.componentes;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class PantallaLista extends Pantalla {
    private final AbstractTableModel model;
    // TODO cambiar esto. No debe recibir un modelo, sino una sublcase de JTable que
    // sea capaz de construir su propio modelo como un observer al servicio
    // y produzca una actualización modificando su modelo
    public PantallaLista(AbstractTableModel model) {
        this.model = model;
        JScrollPane scrollTabla = new JScrollPane(new JTable(model));
        addComponente(scrollTabla);
    }
}
