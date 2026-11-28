package Espacios;
import Calendario.*;
import entidades.personas.empleados.*;
public abstract class SalasEspeciales extends Espacio{
    private Coach coachAsignado;
    
    public SalasEspeciales(String nombre, int capacidad, Horario horario){
        super(nombre, capacidad, horario);
    }

    public Coach getCoachAsignado(){
        return coachAsignado;
    }

    public void setCoachAsignado(Coach coach){
        this.coachAsignado=coach;
    }

    public void iniciarClase(Coach coach){
        setCoachAsignado(coach);
        System.out.println("La clase ha iniciado");
        setEstado(Disponibilidad.HAYCLASE);
    }

    public void finalizarClase(){
        System.out.println("La clase ha finalizado");
        setEstado(Disponibilidad.DISPONIBLE);
    }
}