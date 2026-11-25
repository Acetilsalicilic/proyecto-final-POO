package ui.gui.admin.usuarios;

import ui.gui.componentes.Submenu;

public class SubmenuUsuarios extends Submenu {
    public SubmenuUsuarios() {
        tabs.addTab("Lista de usuarios", new PantallaListaUsuarios());
    }
}
