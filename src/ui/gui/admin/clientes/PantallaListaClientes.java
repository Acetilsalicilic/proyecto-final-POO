package ui.gui.admin.clientes;

import entidades.personas.Cliente;
import servicios.ServicioClientes;
import ui.gui.componentes.ModeloTabla;
import ui.gui.componentes.PantallaLista;

import javax.swing.*;

public class PantallaListaClientes extends PantallaLista {
    private static final String[] nombres = {"Nombre", "Membresía", "Coach", "# clases inscritas"};
    public PantallaListaClientes() {
        ModeloTabla<Cliente> modelo = new ModeloTabla<>(
                ServicioClientes.instancia(),
                (c, col) -> {
                    return switch (col) {
                        case 0 -> c.getNombre();
                        case 1 -> c.getMembresia() != null ? c.getMembresia().getMembresia().getNombre() : "Sin membresía";
                        case 2 -> c.getCoach() != null ? c.getCoach().getNombre() : "Sin coach asignado";
                        case 3 -> c.getClasesInscritas().size();
                        default -> null;
                    };
                },
                nombres
        );
        super(new JTable(modelo));

        PantallaEditarCliente editarCliente = new PantallaEditarCliente(15, () -> cardLayout.show(this, PRINCIPAL));
        addPantallaEditar(editarCliente);
        addEnEditar(obj -> {
            if (obj instanceof Cliente c)
                editarCliente.editarCliente(c);
            cardLayout.show(this, EDITAR);
        });
    }
}
