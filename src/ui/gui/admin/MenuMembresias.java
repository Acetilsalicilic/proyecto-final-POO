package ui.gui.admin;

import entidades.membresias.Membresia;
import ui.gui.GUI;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class MenuMembresias extends JPanel {
    public static final String MENU_MEMBRESIAS = "menuMembresias";

    private JTabbedPane tabs = new JTabbedPane();
    private JPanel splash = new JPanel();
    private JLabel titulo;

    public MenuMembresias() {
        setLayout(new BorderLayout());

        // Configurar splash
        tabs.addTab("Principal", splash);

        titulo = new JLabel("Menú membresías");
        titulo.setFont(GUI.TITLE_FONT);
        splash.add(titulo);

        // Configurar lista de membresias
        tabs.addTab("Lista de membresías", new MenuListaMembresias());

        // Configurar menu crear membresia
        tabs.addTab("Crear membresía", new MenuCrearMembresia());

        add(tabs, BorderLayout.CENTER);
    }
}

class MenuListaMembresias extends JPanel {
    private JScrollPane scroll;
    private JPanel container = new JPanel();
    private JTable table;
    private JLabel title;

    public MenuListaMembresias() {
        setLayout(new BorderLayout());
        scroll = new JScrollPane(container);
        add(scroll, BorderLayout.CENTER);
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        title = new JLabel("Lista de membresías");
        title.setFont(GUI.TITLE_FONT);
        container.add(title);

        // Añadir la tabla de membresías
        table = new JTable(new ListaMembresiasModel());
        JScrollPane tableScroll = new JScrollPane(table);

        container.add(tableScroll);
    }
}

class ListaMembresiasModel extends AbstractTableModel {
    private java.util.List<Membresia> membresias;
    private String[] titulos = {"Nombre", "Incluye coach", "Descuento de temporada"};
    public ListaMembresiasModel() {
        // TODO observer for updating this
        membresias = Membresia.membresiasDisponibles;
    }

    @Override
    public int getRowCount() {
        return membresias.size();
    }

    @Override
    public int getColumnCount() {
        // TODO colocar columnas reales
        return 3;
    }

    @Override
    public Object getValueAt(int r, int c) {
        var obj = membresias.get(r);

        return switch (c) {
            case 0 -> obj.getNombre();
            case 1 -> obj.getCostoBase();
            case 2 -> obj.getDescuentoTemporada();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int c) {
        return titulos[c];
    }
}

class MenuCrearMembresia extends JPanel {
    public MenuCrearMembresia() {
        JLabel title = new JLabel("Crear membresía");
        title.setFont(GUI.TITLE_FONT);
        add(title);
    }
}