package servicios;

import entidades.personas.Persona;

import java.util.ArrayList;
import java.util.List;

public class ServicioPersona implements IServicio<Persona>, ISuscriptor {
    private List<IServicio<? extends Persona>> servicios;
    private List<Persona> lista = new ArrayList<>();
    private List<ISuscriptor> subs = new ArrayList<>();

    private static ServicioPersona instancia = new ServicioPersona();
    public static ServicioPersona getInstance() { return instancia; }

    private ServicioPersona() {
        servicios = List.of(
                ServicioCoach.instancia()
        );

        // Suscribirse a todos lados
        servicios.forEach(s -> s.suscribir(this));

        notificar();
    }

    @Override
    public List<Persona> getTodos() {
        return lista;
    }

    @Override
    public void agregar(Persona e) {
        throw new UnsupportedOperationException("No se puede utilizar este método");
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

    @Override
    public void notificar() {
        lista.clear();
        for (var s : servicios)
            lista.addAll(s.getTodos());
    }
}
