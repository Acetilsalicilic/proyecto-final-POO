package ui.gui.admin;

import ui.gui.componentes.PantallaLista;

import javax.swing.table.AbstractTableModel;

public class PantallaListaMembresias extends PantallaLista {
    public PantallaListaMembresias() {
        super(new ModeloListaMembresias());
    }
}

class ModeloListaMembresias extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return null;
    }

    @Override
    public String getColumnName(int col) {
        return switch(col) {
            case 0 -> "Nombre";
            default -> null;
        };
    }
}
