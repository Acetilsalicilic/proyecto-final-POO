package ui.gui.admin.coaches;

import entidades.personas.empleados.Coach;
import servicios.ServicioCoach;
import ui.gui.componentes.ModeloTabla;
import ui.gui.componentes.PantallaLista;

import javax.swing.*;

public class PantallaListaCoach extends PantallaLista {
    private static final String[] nombres = {"Nombre", "# clientes"};
    public PantallaListaCoach() {
        ModeloTabla<Coach> modelo = new ModeloTabla<>(
                ServicioCoach.instancia(),
                (c, col) -> switch (col) {
                    case 0 -> c.getNombre();
                    case 1 -> c.getClientes().size();
                    default -> null;
                },
                nombres
        );
        super(new JTable(modelo));
    }
}
