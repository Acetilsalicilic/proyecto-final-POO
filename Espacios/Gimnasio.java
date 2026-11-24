package Espacios;

import java.util.ArrayList;
import java.util.List;


public class Gimnasio extends Espacio {
    private List <String> areasDisponibles;

    public Gimnasio (String nombre, int capacidad){
        super(nombre, capacidad);
        this.areasDisponibles= new ArrayList<>();
    }

    public List<String> getAreasDiponibles(){
        return areasDisponibles;
    }
     
    @Override 
    public boolean puedeIngresar(){
        //tampoco me acuerdo
        return true;
    }

    
}
