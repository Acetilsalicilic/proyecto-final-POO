package ui.gui.admin.coaches;

import ui.gui.componentes.Submenu;

public class SubmenuCoach extends Submenu {
    public SubmenuCoach() {
        tabs.addTab("Lista coaches", new PantallaListaCoach());
        tabs.addTab("Registrar coach", new PantallaCrearCoach(15));
    }
}
