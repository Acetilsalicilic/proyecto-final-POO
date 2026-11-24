package Espacios;
public class SalasEspeciales extends Espacio{
    
    public SalasEspeciales(String nombre, int capacidad){
        super(nombre, capacidad);
    }

    public void iniciarClase(){
        System.out.println("La clase ha iniciado");
        setEstado(Disponibilidad.HAYCLASE);
    }

    public void finalizarClase(){
        System.out.println("La clase ha finalizado");
        setEstado(Disponibilidad.DISPONIBLE);
    }
}