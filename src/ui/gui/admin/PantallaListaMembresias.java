package ui.gui.admin;

import entidades.membresias.Membresia;
import servicios.ServicioMembresias;
import ui.gui.componentes.ISuscriptor;
import ui.gui.componentes.PantallaLista;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PantallaListaMembresias extends PantallaLista {
    public PantallaListaMembresias() {
        super(new ModeloListaMembresias(ServicioMembresias.instancia()));
    }
}

class ModeloListaMembresias extends AbstractTableModel implements ISuscriptor {
    private ServicioMembresias membresias;
    private List<Membresia> lista;

    public ModeloListaMembresias(ServicioMembresias servicio) {
        membresias = servicio;
        servicio.suscribir(this);

        lista = servicio.getTodos();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int r, int c) {
        var obj = lista.get(r);

        return switch (c) {
            case 0 -> obj.getNombre();
            case 1 -> obj.getCostoBase();
            case 3 -> obj.isIncluyeCoach();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int col) {
        return switch(col) {
            case 0 -> "Nombre";
            case 1 -> "Costo base";
            case 2 -> "Incluye coach?";
            default -> null;
        };
    }

    @Override
    public void notificar() {
        throw new UnsupportedOperationException("No implementado");
    }
}
