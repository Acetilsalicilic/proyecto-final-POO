package entidades.personas.empleados;

import entidades.personas.Persona;

import java.util.HashSet;
import java.util.Set;

public class Coach extends Empleado {
    private Set<Persona> clientes = new HashSet<>();
    public Coach(String nombre) {
        super(nombre);
    }

    public Set<Persona> getClientes() { return clientes; }
}
