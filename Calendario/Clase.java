package Calendario;

import entidades.personas.*;
import entidades.personas.empleados.*;
import entidades.actividades.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Clase extends Actividad {
    private TipoClase tipoClase;
    private int cupoMaximo;
    private Coach coachAsignado; 
    private Set<Persona> personasInscritas; 

    public Clase(TipoClase tipoClase, int cupoMaximo, Coach coachAsignado, LocalTime horaInicio, LocalTime horaFin) {
        super("Clase de " + tipoClase.name(), horaInicio, horaFin);
        this.tipoClase = tipoClase;
        this.cupoMaximo = cupoMaximo;
        this.coachAsignado = coachAsignado;
        this.personasInscritas = new HashSet<>();
    }

    public TipoClase getTipoClase(){ 
        return tipoClase; 
    }
    public Coach getCoachAsignado(){ 
        return coachAsignado; 
    }
    public Set<Persona> getPersonasInscritas(){ 
        return personasInscritas; 
    }

    public int getCupoMaximo(){
        return cupoMaximo;
    }

    public int getCupoDisponible() {
        return getCupoMaximo() - getPersonasInscritas().size();
    }

    public boolean inscribirPersona(Persona persona) {
        if (getPersonasInscritas().size() >=getCupoMaximo()) {
            System.out.println("No hay cupo disponible para la clase de " + getTipoClase());
            return false;
        }

        if (getPersonasInscritas().contains(persona)) {
            System.out.println(persona.getNombre() + " ya se encuentra inscrito/a en esta clase.");
            return false;
        }

        agregarPersonaInscrita(persona);
        System.out.println(persona.getNombre() + " se ha inscrito exitosamente a la clase de " + getTipoClase());
        return true;
    }

    public boolean cancelarInscripcion(Persona persona) {
        if (getPersonasInscritas().remove(persona)) {
            System.out.println("Inscripción cancelada para " + persona.getNombre());
            return true;
        }
        return false;
    }

    public void agregarPersonaInscrita(Persona persona){
        personasInscritas.add(persona);
    }
}