package ui.gui.componentes;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class PantallaLista extends Pantalla {
    protected static final String EDITAR = "editar";

    protected JButton botonEditar;
    protected PantallaCampos pantallaEditar;
    protected JTable tabla;

    public PantallaLista(JTable tabla) {
        this.tabla = tabla;

        JScrollPane scrollTabla = new JScrollPane(tabla);
        addComponente(scrollTabla);

        // Añadir botones de editar y eliminar
        JPanel botones = new JPanel(new FlowLayout());
        botonEditar = new JButton("Editar");
        botones.add(botonEditar);

        addComponente(botonEditar);
    }
    public void addPantallaEditar(PantallaCampos pantallaEditar) {
        this.pantallaEditar = pantallaEditar;
        addCard(pantallaEditar, EDITAR);
    }
    public void addEnEditar(Consumer<Object> enEditar) {
        botonEditar.addActionListener(_ -> {
            var modelo = (ModeloTabla<?>) tabla.getModel();
            var obj = modelo.getRow(tabla.getSelectedRow());
            enEditar.accept(obj);

        });
    }
}
