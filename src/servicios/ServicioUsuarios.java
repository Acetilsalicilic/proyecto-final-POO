package servicios;

import entidades.personas.Persona;
import entidades.personas.empleados.Administrador;
import entidades.personas.empleados.Coach;
import entidades.sistema.Usuario;

import java.util.*;

public class ServicioUsuarios implements IServicio<Usuario> {
    private static final ServicioUsuarios instancia = new ServicioUsuarios();
    public static ServicioUsuarios instancia() { return instancia; }

    private final Map<Usuario, Persona> mappings = new HashMap<>();
    private final List<Usuario> lista = new ArrayList<>();
    private final List<ISuscriptor> subs = new ArrayList<>();

    private ServicioUsuarios() {
        agregar(
                new Usuario("admin", "admin"),
                new Administrador("Default")
        );
        agregar(
                new Usuario("asd", "asd"),
                new Coach("Raul")
        );
    }

    public Optional<Persona> verificar(Usuario usuario) {
        if (!lista.contains(usuario))
            return Optional.empty();

        return Optional.of(getMapping(usuario));
    }

    public Persona getMapping(Usuario usuario) {
        return mappings.get(usuario);
    }

    @Override
    public List<Usuario> getTodos() {
        return lista;
    }

    @Override
    public void agregar(Usuario e) {
        throw new UnsupportedOperationException("No es posible usar este método");
    }

    public void agregar(Usuario e, Persona p) {
        lista.add(e);
        mappings.put(e, p);
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
        subs.forEach(ISuscriptor::notificar);
    }
}
