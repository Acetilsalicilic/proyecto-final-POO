package Espacios;
public class SaunaComun extends Sauna {
    private static int contador=0;
    private int idSauna;

    public SaunaComun (String nombre, int capacidad){
        contador++;
        super(nombre, capacidad);
        this.idSauna=contador;
    }
    
    public int getId(){
        return idSauna;
    }

    
    @Override 
    public boolean puedeIngresar(){
        //no recuerdo por que dije que iban override, me muero, te preguntare
        return true;
    }
}
