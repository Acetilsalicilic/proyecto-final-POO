package Espacios;
public class EspacioSpinning extends SalasEspeciales {
    public EspacioSpinning (String nombre, int capacidad){
        super(nombre, capacidad);
    }

    @Override 
    public boolean puedeIngresar(){
        //tampoco me acuerdo
        return true;
    }
}
