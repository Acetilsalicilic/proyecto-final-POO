package Espacios;
import Calendario.*;
import entidades.personas.*;
import entidades.personas.empleados.*;

public class EspacioBox extends SalasEspeciales {
    private boolean ringDisponible;

    public EspacioBox(String name, int capacidad, Horario horario){
        super(name, capacidad, horario);
        this.ringDisponible=false;
    }

    @Override
    public void iniciarClase(Coach coach) {
        super.iniciarClase(coach);
        setRingDisponible(true);
    }

    @Override
    public void finalizarClase() {
        super.finalizarClase();
        setRingDisponible(false);
    }

    @Override
    public boolean puedeIngresar(Persona persona) {
        if (persona.getMembresia() == null) {
            System.out.println("Acceso denegado: Se requiere una membresía activa");
            return false;
        }

        if (getEstado()!= Disponibilidad.DISPONIBLE) {
            System.out.println("El area de box no esta disponnible por el momento");
            return false;
        }

        if (!hayEspacio()) {
            System.out.println("Acceso denegado: Salón de Box lleno.");
            return false;
        }

        System.out.println("Puede ingresar al area de box, si necesita el ring, avise para desbloquear");
        return true;
    }

    public boolean getRingDisponible() {
        return ringDisponible;
    }

    public void setRingDisponible(boolean ringDisponible) {
        this.ringDisponible = ringDisponible;
    }
    
}
