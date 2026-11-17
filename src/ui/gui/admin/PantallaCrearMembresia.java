package ui.gui.admin;

import entidades.membresias.MembresiaDummy;
import servicios.ServicioMembresias;
import ui.gui.componentes.PantallaCampos;

import javax.swing.*;
import java.util.List;

public class PantallaCrearMembresia extends PantallaCampos {
    private JTextField nombre, precioBase;
    private JCheckBox coach;
    private JComboBox<String> selectorTipo;

    public PantallaCrearMembresia() {
        super(15);

        nombre = new JTextField(ancho);
        precioBase = new JTextField(ancho);
        coach = new JCheckBox();
        selectorTipo = new JComboBox<>(new String[]{"Dummy"});

        addFila("Tipo", selectorTipo);
        addFila("Nombre", nombre);
        addFila("Precio base", precioBase);
        addFila("¿Incluye coach?", coach);

        var crear = new JButton("Crear");
        crear.addActionListener(evt -> {
            String nombre_s = nombre.getText();
            String precioBase_s = precioBase.getText();
            boolean incluyeCoach_b = coach.isSelected();

            ServicioMembresias.instancia().agregar(new MembresiaDummy(nombre_s));
        });
        addFila(crear);
    }
}
