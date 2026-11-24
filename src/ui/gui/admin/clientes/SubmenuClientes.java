package ui.gui.admin.clientes;

import ui.gui.componentes.Submenu;

public class SubmenuClientes extends Submenu {
    public SubmenuClientes() {
        tabs.add("Lista clientes", new PantallaListaClientes());
        tabs.add("Registrar cliente", new PantallaCrearCliente(15));
    }
}
