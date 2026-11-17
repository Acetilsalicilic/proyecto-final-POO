package ui.gui.admin;

import ui.gui.componentes.PantallaCampos;

public class PantallaCrearMembresia extends PantallaCampos {
    public PantallaCrearMembresia() {
        super(
                mapa -> {
                    mapa.keySet().forEach(key -> System.out.print(""+key+": "+mapa.get(key)+", "));
                },
                "Crear membresía",
                15,
                "Nombre",
                "Costo base",
                "¿Incluye coach?"
        );
    }
}
