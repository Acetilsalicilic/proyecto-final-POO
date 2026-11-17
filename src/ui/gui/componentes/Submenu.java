package ui.gui.componentes;

import javax.swing.*;
import java.awt.*;

public abstract class Submenu extends JPanel {
    protected JTabbedPane tabs = new JTabbedPane();
    public Submenu() {
        setLayout(new BorderLayout());
        add(tabs, BorderLayout.CENTER);
    }
}
