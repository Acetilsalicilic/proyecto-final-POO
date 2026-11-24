package entidades.personas;

import entidades.actividades.Clase;
import entidades.membresias.Membresia;
import entidades.membresias.MembresiaCliente;
import entidades.personas.empleados.Coach;

import java.util.HashSet;
import java.util.Set;

public abstract class Persona {
    protected String nombre;
    protected MembresiaCliente membresia;
    protected Coach coach;

    protected Set<Clase> clasesInscritas = new HashSet<>();

    public Persona(String nombre, MembresiaCliente membresia, Coach coach) {
        this.nombre = nombre;
        this.membresia = membresia;
        this.coach = coach;
    }

    public Persona(String nombre) {
        this(nombre, null, null);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MembresiaCliente getMembresia() {
        return membresia;
    }

    public void setMembresia(MembresiaCliente membresia) {
        this.membresia = membresia;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Set<Clase> getClasesInscritas() {
        return clasesInscritas;
    }

    public void setClasesInscritas(Set<Clase> clasesInscritas) {
        this.clasesInscritas = clasesInscritas;
    }
}
