package Espacios;
import Calendario.*; 
import entidades.personas.*; 
import entidades.personas.empleados.*;

import java.util.ArrayList;
import java.util.List;


public class Gimnasio extends Espacio {
    private List <String> areasDisponibles;
    private List <Coach> entrenadoresEnTurno;

    public Gimnasio (String nombre, int capacidad, Horario horario){
        super(nombre, 500, horario);
        this.areasDisponibles= new ArrayList<>();
        this.entrenadoresEnTurno = new ArrayList<>();
        inicializarAreas();
    }

    private void inicializarAreas(){ 
        areasDisponibles.add("Peso Libre");
        areasDisponibles.add("Cardio");
        areasDisponibles.add("Máquinas Guiadas");
        areasDisponibles.add("Entrenamiento Funcional");
    }

    public void agregarArea(String area){
        areasDisponibles.add(area);
    }

    public List<String> getAreasDiponibles(){
        return areasDisponibles;
    }

    public List <String> getAreasDisponibles(){
        return areasDisponibles;
    }

    public List <Coach> getEntrenadoresEnTurno(){
        return entrenadoresEnTurno;
    }
     
    @Override 
    public boolean puedeIngresar(Persona persona){
        if (persona.getMembresia() == null){ 
            System.out.println("Acceso denegado: La persona no cuenta con una membresía activa"); 
            return false; 
        } 
        
        if (getEstado()== Disponibilidad.ENMANTENIMIENTO){
            System.out.println("El gym se encuentra en mantenimiento");
            return false; 
        }

        return true;
    }

    public void registrarEntrenadorTurno(Coach entrenador){ 
        if (!entrenadoresEnTurno.contains(entrenador)){ 
            entrenadoresEnTurno.add(entrenador);
            System.out.println("Coach " + entrenador.getNombre() + " ingresó a su turno de supervisión."); 
        } 
    }

    public void retirarEntrenadorTurno(Coach entrenador){ 
        entrenadoresEnTurno.remove(entrenador);
        System.out.println("Coach " + entrenador.getNombre() + " concluyó su turno en el gimnasio.");
    }

    public boolean haySupervisionSuficiente(){ 
        return entrenadoresEnTurno.size() <= 2; 
    }
    
    
}
