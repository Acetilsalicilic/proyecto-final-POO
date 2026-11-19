package ui.gui.admin;

import servicios.ServicioMembresias;
import ui.gui.componentes.Submenu;

public class SubmenuMembresias extends Submenu {
    public SubmenuMembresias() {
        super();

        tabs.addTab("Lista membresías", new PantallaListaMembresias());
        tabs.addTab("Crear membresía", new PantallaCrearMembresia(15));
    }
}
