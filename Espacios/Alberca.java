package Espacios;

import entidades.personas.Persona;

public class Alberca extends Espacio {
    private double temperaturaAgua; 

    public Alberca (String nombre, int capacidad){
        super(nombre, capacidad);
    }

     @Override 
    public boolean puedeIngresar(){
        //no recuerdo
        return true;
    }

    public void iniciarLimpiezaDiaria(){
        //aqui algo que sale un mensajito
        System.out.println("La limpieza diaria comenzo");
        setEstado(Disponibilidad.ENMANTENIMIENTO);
    }
    //entre estos dos un temporizador para que salgan los mensajitos

    public void terminarLimpiezaDiaria(){
        //aqui algo que sale un mensajito
        System.out.println("La limpieza diaria termino");
        setEstado(Disponibilidad.DISPONIBLE);
    }

    //estos no se que mas podrian hacer
    public void iniciarLimpiezaProfunda(Persona persona){
       setEstado(Disponibilidad.ENMANTENIMIENTO);
    }

    public void terminarLimpiezaProfunda(){
       setEstado(Disponibilidad.DISPONIBLE);
    }

}
