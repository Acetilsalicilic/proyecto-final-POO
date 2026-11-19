package ui.gui.admin;

import entidades.membresias.Membresia;
import servicios.ServicioMembresias;
import ui.gui.componentes.PantallaCampos;

import javax.swing.*;

public class PantallaCrearMembresia extends PantallaCampos {
    public PantallaCrearMembresia(int ancho) {
        super(ancho);

        addCampoTexto("Nombre");
        addCampoTexto("Precio base");
        addCheck("¿Incluye coach?");


        addBoton("Crear membresía", () -> {
            String nombre = getCampoTexto("Nombre").getText();
            double precioBase = Double.parseDouble(getCampoTexto("Precio base").getText());
            boolean incluyeCoach = getCheckBox("¿Incluye coach?").isSelected();

            Membresia nueva = new Membresia(nombre, precioBase, incluyeCoach);

            ServicioMembresias.instancia().agregar(nueva);

            JOptionPane.showMessageDialog(this, "Membresía creada con éxtio!");
        });
    }
}
