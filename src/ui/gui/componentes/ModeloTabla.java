package ui.gui.componentes;

import servicios.IServicio;
import servicios.ISuscriptor;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.function.BiFunction;

public class ModeloTabla<T> extends AbstractTableModel implements ISuscriptor {
    private List<T> lista = List.of();
    private String[] titulos;
    private BiFunction<T, Integer, Object> getter;
    private IServicio<T> servicio;

    public ModeloTabla(IServicio<T> servicio, BiFunction<T, Integer, Object> getter, String... titulos) {
        this.titulos = titulos;
        this.getter = getter;
        this.servicio = servicio;

        lista = servicio.getTodos();

        servicio.suscribir(this);
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

    @Override
    public Object getValueAt(int r, int c) {
        return getter.apply(lista.get(r), c);
    }

    @Override
    public void notificar() {
        lista = servicio.getTodos();
        fireTableDataChanged();
    }

    public T getRow(int r) {
        return lista.get(r);
    }
}
