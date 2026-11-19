package ui.gui.admin;

import servicios.ServicioMembresias;
import ui.gui.componentes.Submenu;

public class SubmenuMembresias extends Submenu {
    public SubmenuMembresias() {
        super();

        var pantallaEditar = new PantallaEditarMembresia(15);

        tabs.addTab("Lista membresías", new PantallaListaMembresias(
                membresia -> {
                    pantallaEditar.editarMembresia(membresia);
                    tabs.setSelectedComponent(pantallaEditar);
                }
        ));
        tabs.addTab("Crear membresía", new PantallaCrearMembresia(15));
        tabs.addTab("Editar membresia", pantallaEditar);
    }
}
