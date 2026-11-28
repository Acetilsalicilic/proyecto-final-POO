package ui.gui.admin.usuarios;

import entidades.sistema.Usuario;
import servicios.ServicioClientes;
import servicios.ServicioCoach;
import servicios.ServicioUsuarios;
import ui.gui.componentes.ModeloTabla;
import ui.gui.componentes.PantallaLista;

import javax.swing.*;

public class PantallaListaUsuarios extends PantallaLista {
    private static final String[] nombres = {"Nombre de usuario", "Nombre", "Último acceso"};
    public PantallaListaUsuarios() {
        ModeloTabla<Usuario> modelo = new ModeloTabla<>(
                ServicioUsuarios.instancia(),
                (u, col) -> switch (col) {
                    case 0 -> u.getNombreUsuario();
                    case 1 -> ServicioUsuarios.instancia().getMapping(u).getNombre();
                    default -> null;
                },
                nombres
        );
        super(new JTable(modelo));

        // El modelo debe actualizarse con los cambios a cualquier tipo de usuario
        ServicioCoach.instancia().suscribir(modelo);
    }
}
