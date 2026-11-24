package Espacios;
public class EspacioBox extends SalasEspeciales {
    public EspacioBox(String name, int capacidad){
        super(name, capacidad);
    }
    
    @Override 
    public boolean puedeIngresar(){
        //tampoco me acuerdo
        return true;
    }
}
