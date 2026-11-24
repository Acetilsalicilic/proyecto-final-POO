package servicios;

import entidades.personas.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ServicioClientes implements IServicio<Cliente> {
    private static final ServicioClientes instancia = new ServicioClientes();
    public static ServicioClientes instancia() { return instancia; }

    private final List<Cliente> lista = new ArrayList<>();
    private List<ISuscriptor> subs = new ArrayList<>();

    private ServicioClientes() {
        // TODO datos de prueba
        lista.add(new Cliente("Dummy", null, null));
    }

    // TODO implementar esto
    @Override
    public List<Cliente> getTodos() {
        return lista;
    }

    @Override
    public void agregar(Cliente e) {
        lista.add(e);
        notificarTodos();
    }

    @Override
    public void suscribir(ISuscriptor s) {
        subs.add(s);
    }

    @Override
    public void desuscribir(ISuscriptor s) {

    }

    @Override
    public void notificarTodos() {
        subs.forEach(ISuscriptor::notificar);
    }
}
