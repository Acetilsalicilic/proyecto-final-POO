package Espacios;
public class SaunaIndividual extends Sauna {
    private static int contador=0;
    private int idSauna;

    public SaunaIndividual(String nombre, int capacidad){
        contador++;
        super(nombre, capacidad);
        this.idSauna=contador;
    }

    public int getId(){
        return idSauna;
    }

    @Override 
    public boolean puedeIngresar(){
        //tampoco me acuerdo
        return true;
    }
} 