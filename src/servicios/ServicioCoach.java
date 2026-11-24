package servicios;

import entidades.personas.empleados.Coach;

import java.util.ArrayList;
import java.util.List;

public class ServicioCoach implements IServicio<Coach> {
    private final List<Coach> lista = new ArrayList<>();
    private final List<ISuscriptor> subs = new ArrayList<>();

    private static final ServicioCoach instancia = new ServicioCoach();
    public static ServicioCoach instancia() { return instancia; }

    private ServicioCoach() {

    }
    @Override
    public List<Coach> getTodos() {
        return lista;
    }

    @Override
    public void agregar(Coach e) {
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
        System.err.println("Notificando a "+subs.size()+" subs en coaches");
        subs.forEach(ISuscriptor::notificar);
    }
}
