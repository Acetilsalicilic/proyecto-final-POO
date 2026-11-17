package ui.gui.admin;

import entidades.membresias.Membresia;
import servicios.IServicio;
import servicios.ServicioMembresias;
import ui.gui.componentes.ISuscriptor;
import ui.gui.componentes.ModeloTabla;
import ui.gui.componentes.PantallaLista;
import ui.gui.componentes.Tabla;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PantallaListaMembresias extends PantallaLista {
    public PantallaListaMembresias() {
        super(new TablaMembresias(ServicioMembresias.instancia()));
    }
}

class TablaMembresias extends Tabla<Membresia> {

    public TablaMembresias(ServicioMembresias servicio) {
        super(servicio);
    }

    @Override
    public void notificar() {
        modelo = new ModeloListaMembresias(servicio.getTodos());
        setModel(modelo);
    }
}

class ModeloListaMembresias extends ModeloTabla<Membresia> {
    public ModeloListaMembresias(List<Membresia> lista) {
        super(lista, "Nombre", "Costo base");
    }

    @Override
    public Object getValueAt(int r, int c) {
        var obj = lista.get(r);

        return switch (c) {
            case 0 -> obj.getNombre();
            case 1 -> obj.getCostoBase();
            default -> null;
        };
    }
}