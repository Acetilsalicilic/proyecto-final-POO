package ui.gui.admin;

import entidades.personas.empleados.Administrador;
import ui.gui.componentes.PantallaSplash;
import ui.gui.componentes.Vista;

public class VistaAdmin extends Vista {
    public VistaAdmin(Administrador admin) {
        super("Administrador", admin);

        tabs.addTab("Menu principal", new PantallaSplash("Bienvenido, "+persona.getNombre()));
        tabs.addTab("Membresías", new SubmenuMembresias());
    }
}
