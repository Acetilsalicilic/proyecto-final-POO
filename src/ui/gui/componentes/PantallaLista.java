package ui.gui.componentes;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.function.Consumer;

public class PantallaLista extends Pantalla {
    protected static final String EDITAR = "editar";
    protected JButton editar;
    protected PantallaCampos pantallaEditar;
    protected JTable tabla;
    public PantallaLista(JTable tabla) {
        this.tabla = tabla;

        JScrollPane scrollTabla = new JScrollPane(tabla);
        addComponente(scrollTabla);

        // Añadir botones de editar y eliminar
        JPanel botones = new JPanel(new FlowLayout());
        editar = new JButton("Editar");
        botones.add(editar);

        addComponente(editar);
    }
    public void addPantallaEditar(PantallaCampos pantallaEditar) {
        this.pantallaEditar = pantallaEditar;
        addCard(pantallaEditar, EDITAR);
    }
    public void addEnEditar(Consumer<Object> enEditar) {
        editar.addActionListener(_ -> {
            var modelo = (ModeloTabla<? extends Object>) tabla.getModel();
            var obj = modelo.getRow(tabla.getSelectedRow());
            enEditar.accept(obj);

        });
    }
}
