package ui.gui.componentes;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.function.Consumer;

public class PantallaLista extends Pantalla {
    public PantallaLista(JTable tabla, Consumer<Object> enEditar) {
        JScrollPane scrollTabla = new JScrollPane(tabla);
        addComponente(scrollTabla);

        // Añadir botones de editar y eliminar
        JPanel botones = new JPanel(new FlowLayout());
        JButton editar = new JButton("Editar");
        botones.add(editar);

        editar.addActionListener(_ -> {
            var modelo = (ModeloTabla<? extends Object>) tabla.getModel();
            var obj = modelo.getRow(tabla.getSelectedRow());
            enEditar.accept(obj);
        });

        addComponente(editar);
    }
}
