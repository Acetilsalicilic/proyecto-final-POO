package ui.gui.admin.clientes;

import entidades.membresias.Membresia;
import entidades.membresias.MembresiaCliente;
import entidades.personas.Cliente;
import entidades.personas.empleados.Coach;
import servicios.ServicioClientes;
import servicios.ServicioCoach;
import servicios.ServicioMembresias;
import ui.gui.componentes.PantallaCampos;
import ui.gui.componentes.Selector;

import javax.swing.*;

public class PantallaCrearCliente extends PantallaCampos {
    private final Selector<Membresia> selectorMembresia;
    private final Selector<Coach> selectorCoach;

    public PantallaCrearCliente(int ancho) {
        super(ancho);

        selectorMembresia = new Selector<>(ServicioMembresias.instancia(), Membresia::getNombre);
        selectorCoach = new Selector<>(ServicioCoach.instancia(), Coach::getNombre);

        addCampoTexto("Nombre");
        addFila("Membresía", selectorMembresia);
        addFila("Coach", selectorCoach);

        addBoton("Registrar cliente", () -> {
            String nombre = getCampoTexto("Nombre").getText();
            Membresia membresia = selectorMembresia.getSeleccionado().get();

            Coach coach = null;
            if (membresia.isIncluyeCoach()) {
                if (selectorCoach.getSeleccionado().isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            """
                                    Error: La membresía "%s" incluye un coach.
                                    
                                    Por favor, selecciona uno de la lista.
                                    """.formatted(membresia.getNombre())
                    );
                    return;
                } else {
                    coach = selectorCoach.getSeleccionado().get();
                }
            }


            Cliente nuevo = new Cliente(nombre, new MembresiaCliente(membresia), coach);

            ServicioClientes.instancia().agregar(nuevo);
            JOptionPane.showMessageDialog(this, "Cliente registrado con éxito");
        });
    }
}
