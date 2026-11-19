package servicios;

import entidades.membresias.Membresia;

import java.util.ArrayList;
import java.util.List;

public class ServicioMembresias implements IServicio<Membresia> {
    private List<Membresia> membresias = new ArrayList<>();
    private List<ISuscriptor> subs = new ArrayList<>();

    private static ServicioMembresias instancia = new ServicioMembresias();
    public static ServicioMembresias instancia() { return instancia; }

    private ServicioMembresias() {
        // TODO dummy data
    }

    @Override
    public List<Membresia> getTodos() {
        return membresias;
    }

    // Observer
    @Override
    public void agregar(Membresia e) {
        membresias.add(e);
        notificarTodos();
    }

    @Override
    public void suscribir(ISuscriptor s) {
        subs.add(s);
    }

    @Override
    public void desuscribir(ISuscriptor s) {
        subs.remove(s);
    }

    @Override
    public void notificarTodos() {
        System.err.println("Notificando a todos los subs");
        subs.forEach(ISuscriptor::notificar);
    }
}
