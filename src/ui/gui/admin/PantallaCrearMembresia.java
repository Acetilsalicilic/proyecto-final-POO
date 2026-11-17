package ui.gui.admin;

import entidades.membresias.MembresiaDummy;
import servicios.ServicioMembresias;
import ui.gui.componentes.PantallaCampos;

public class PantallaCrearMembresia extends PantallaCampos {
    public PantallaCrearMembresia() {
        super(
                mapa -> {
                    ServicioMembresias.instancia().agregar(new MembresiaDummy(mapa.get("Nombre")));
                },
                "Crear membresía",
                15,
                "Nombre",
                "Costo base",
                "¿Incluye coach?"
        );
    }
}
