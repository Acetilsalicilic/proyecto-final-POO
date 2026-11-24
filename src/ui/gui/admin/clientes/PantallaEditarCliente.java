package ui.gui.admin.clientes;

import entidades.membresias.Membresia;
import entidades.personas.Cliente;
import entidades.personas.empleados.Coach;
import servicios.ServicioClientes;
import servicios.ServicioCoach;
import servicios.ServicioMembresias;
import ui.gui.componentes.PantallaCampos;
import ui.gui.componentes.Selector;

import java.util.List;

public class PantallaEditarCliente extends PantallaCampos {
    private final String[] etiquetas = {"Nombre", "Membresía", "Coach"};
    private final Selector<Membresia> selectorMembresia;
    private final Selector<Coach> selectorCoach;
    private Cliente cliente;

    public PantallaEditarCliente(int ancho, Runnable afterGuardar) {
        super(ancho);

        selectorMembresia = new Selector<>(ServicioMembresias.instancia(), Membresia::getNombre);
        selectorCoach = new Selector<>(ServicioCoach.instancia(), Coach::getNombre);

        addCampoTexto(etiquetas[0]);
        addFila(etiquetas[1], selectorMembresia);
        addFila(etiquetas[2], selectorCoach);

        addBoton("Guardar", () -> {
            String nombre = getCampoTexto(etiquetas[0]).getText();
            Membresia membresia = selectorMembresia.getSeleccionado().get();
            Coach coach = selectorCoach.getSeleccionado().get();

            cliente.setNombre(nombre);
            cliente.getMembresia().setMembresia(membresia);
            cliente.setCoach(coach);

            ServicioClientes.instancia().notificarTodos();

            asignarValores();

            afterGuardar.run();
        });
    }
    public void editarCliente(Cliente cliente) {
        this.cliente = cliente;
        asignarValores();
    }
    private void asignarValores () {
        setTextoCampo(etiquetas[0], cliente.getNombre());
        selectorMembresia.setSelectedItem(cliente.getMembresia().getMembresia().getNombre());
        selectorCoach.setSelectedItem(cliente.getCoach());
    }
}
