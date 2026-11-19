package ui.gui.admin;

import entidades.membresias.Membresia;
import servicios.ServicioMembresias;
import ui.gui.componentes.PantallaCampos;

import javax.swing.*;

public class PantallaCrearMembresia extends PantallaCampos {
    public PantallaCrearMembresia() {
        super(15);

        addCampoTexto("Nombre");
        addCampoTexto("Precio base");
        addCheck("¿Incluye coach?");


        addBoton("Crear membresía", () -> {
            String nombre = ((JTextField) get("Nombre")).getText();
            double precioBase = Double.parseDouble(((JTextField) get("Precio base")).getText());
            boolean incluyeCoach = ((JCheckBox) get("¿Incluye coach?")).isSelected();

            Membresia nueva = new Membresia(nombre, precioBase, incluyeCoach);

            ServicioMembresias.instancia().agregar(nueva);
        });
    }
}
