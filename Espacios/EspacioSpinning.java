package Espacios;
import Calendario.*;
import entidades.personas.*;

public class EspacioSpinning extends SalasEspeciales {
    private int numeroBicicletas;
    private int bicicletasOcupadas;

    public EspacioSpinning(String nombre, int capacidad, Horario horario) {
        super(nombre, 30, horario);
        this.numeroBicicletas = capacidad+1;
        this.bicicletasOcupadas = 0;
    }

    public int getBicicletasDisponibles() {
        return getNumeroBicicletas() -getBicicletasOcupadas();
    }

    public int getBicicletasOcupadas(){
        return bicicletasOcupadas;
    }

    public int getNumeroBicicletas(){
        return numeroBicicletas;
    }

    
    
    @Override
    public boolean puedeIngresar(Persona persona) {
        if (persona.getMembresia() == null) {
            System.out.println("Acceso denegado: Se requiere membresía activa.");
            return false;
        }

        if (getEstado() != Disponibilidad.DISPONIBLE) {
            System.out.println("La sala de Spinning no esta diponible por el momento");
            return false;
        }

        if (!hayEspacio()){
            System.out.println("La sala de spinning se encuentra llena");
            return false;
        }

        return true;
    }

    public boolean ocuparBicicleta() {
        if (getBicicletasOcupadas() < getNumeroBicicletas()-1) {
            bicicletasOcupadas++;
            return true;
        }
        
        return false;
    }

    public void liberarBicicletas() {
        this.bicicletasOcupadas = 0;
    }

    
}

