package Espacios;

import Calendario.Horario;
import entidades.personas.Persona;

public class SaunaComun extends Sauna {
    private static int contador=0;
    private int idSauna;

    public SaunaComun (String nombre, int capacidad, Horario horario){
        contador++;
        super(nombre, capacidad, horario);
        this.idSauna=contador;
    }
    
    public int getId(){
        return idSauna;
    }

    
    @Override 
    public boolean puedeIngresar(Persona persona){ 
        if (persona.getMembresia() == null){ 
            System.out.println("Acceso denegado: La persona no cuenta con una membresía activa"); 
            return false; 
        } 
        
        if (getEstado()!= Disponibilidad.DISPONIBLE){
            System.out.println("El sauna no esta disponible");
            return false; 
        } 

        if (!hayEspacio()){ 
            return false; 
        }

        return true;
    }
}
