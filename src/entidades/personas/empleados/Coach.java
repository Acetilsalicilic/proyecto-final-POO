package entidades.personas.empleados;

import entidades.personas.Persona;

import java.util.Set;

public class Coach extends Empleado {
    private Set<Persona> clientes;
    public Coach(String nombre) {
        super(nombre);
    }
}
