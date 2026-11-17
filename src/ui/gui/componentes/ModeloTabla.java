package ui.gui.componentes;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public abstract class ModeloTabla<T> extends AbstractTableModel {
    protected List<T> lista;
    protected String[] titulos;

    public ModeloTabla(List<T> lista, String... titulos) {
        this.lista = lista;
        this.titulos = titulos;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public String getColumnName(int c) {
        return titulos[c];
    }
}
