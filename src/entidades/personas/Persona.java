package entidades.personas;

import entidades.actividades.Clase;
import entidades.membresias.Membresia;
import entidades.personas.empleados.Coach;

import java.util.HashSet;
import java.util.Set;

public class Persona {
    protected String nombre;
    protected Membresia membresia;
    protected Coach coach;

    protected Set<Clase> clasesInscritas = new HashSet<>();
}
