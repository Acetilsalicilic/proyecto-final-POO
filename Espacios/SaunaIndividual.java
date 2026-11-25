package Espacios;
import Calendario.*;
import entidades.personas.*;;
public class SaunaIndividual extends Sauna {
    private static int contador=0;
    private int idSauna;

    public SaunaIndividual(String nombre, Horario horario){
        contador++;
        super(nombre, 1, horario);
        this.idSauna=contador;
    }

    public int getId(){
        return idSauna;
    }

    @Override 
    public boolean puedeIngresar(Persona persona){
        if (persona.getMembresia() == null){
            System.out.println("Acceso denegado: la persona no cuenta con una membresia activa");
            return false;
        }

        if (getEstado()!=Disponibilidad.DISPONIBLE){
            System.out.println("Acceso denegado: el sauna no esta disponible");
            return false;
        }

        if (!getPersonasPresentes().isEmpty()){ 
            System.out.println("Acceso denegado: El sauna individual ya se encuentra ocupada.");
            return false; 
        } 
    
        return true;
    }
} 