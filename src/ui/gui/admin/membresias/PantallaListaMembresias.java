package ui.gui.admin.membresias;

import entidades.membresias.Membresia;
import servicios.ServicioMembresias;
import ui.gui.componentes.ModeloTabla;
import ui.gui.componentes.PantallaLista;

import javax.swing.*;

public class PantallaListaMembresias extends PantallaLista {
    public PantallaListaMembresias() {
        ModeloTabla<Membresia> modelo = new ModeloTabla<>(
                ServicioMembresias.instancia(),
                (membresia, idx) -> switch (idx) {
                    case 0 -> membresia.getNombre();
                    case 1 -> membresia.getCostoBase();
                    case 2 -> membresia.isIncluyeCoach();
                    case 3 -> membresia.getDescuentoTemporada();
                    default -> null;
                },
                "Nombre",
                "Costo base",
                "¿Incluye coach?",
                "Dcto. de temporada"
        );
        super(new JTable(modelo));

        PantallaEditarMembresia editarMembresia = new PantallaEditarMembresia(15, () -> {
            cardLayout.show(this, PRINCIPAL);
            // Todos deben notificarse para reconstruir el nombre guardado
            ServicioMembresias.instancia().notificarTodos();
        });
        addPantallaEditar(editarMembresia);

        addEnEditar(obj -> {
            if (obj instanceof Membresia m)
                editarMembresia.editarMembresia(m);
            cardLayout.show(this, EDITAR);
        });
    }
}
