package ui.gui.admin.clientes;

import entidades.membresias.Membresia;
import entidades.personas.Cliente;
import servicios.ServicioClientes;
import servicios.ServicioMembresias;
import ui.gui.componentes.PantallaCampos;
import ui.gui.componentes.Selector;

public class PantallaEditarCliente extends PantallaCampos {
    private final String[] etiquetas = {"Nombre", "Membresía"};
    private final Selector<Membresia> selectorMembresia;
    private Cliente cliente;

    public PantallaEditarCliente(int ancho, Runnable afterGuardar) {
        super(ancho);

        selectorMembresia = new Selector<>(ServicioMembresias.instancia(), Membresia::getNombre);

        addCampoTexto(etiquetas[0]);
        addFila(etiquetas[1], selectorMembresia);

        addBoton("Guardar", () -> {
            String nombre = getCampoTexto(etiquetas[0]).getText();
            Membresia membresia = selectorMembresia.getSeleccionado().get();

            cliente.setNombre(nombre);
            cliente.getMembresia().setMembresia(membresia);

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
    }
}
