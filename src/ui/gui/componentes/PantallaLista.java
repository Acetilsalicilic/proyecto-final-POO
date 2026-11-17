package ui.gui.componentes;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class PantallaLista extends Pantalla {
    // TODO cambiar esto. No debe recibir un modelo, sino una sublcase de JTable que
    // sea capaz de construir su propio modelo como un observer al servicio
    // y produzca una actualización modificando su modelo
    public PantallaLista(Tabla tabla) {
        JScrollPane scrollTabla = new JScrollPane(tabla);
        addComponente(scrollTabla);
    }
}
