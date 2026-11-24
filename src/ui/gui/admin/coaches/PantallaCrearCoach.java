package ui.gui.admin.coaches;

import entidades.personas.empleados.Coach;
import servicios.ServicioCoach;
import ui.gui.componentes.PantallaCampos;

import javax.swing.*;

public class PantallaCrearCoach extends PantallaCampos {
    public PantallaCrearCoach(int ancho) {
        super(ancho);

        addCampoTexto("Nombre");

        addBoton("Registrar coach", () -> {
            String nombre = getCampoTexto("Nombre").getText();

            Coach nuevo = new Coach(nombre);

            ServicioCoach.instancia().agregar(nuevo);
            JOptionPane.showMessageDialog(this, "Coach registrado exitosamente");
        });
    }
}
