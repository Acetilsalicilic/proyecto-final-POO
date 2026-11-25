package Espacios;

import Calendario.*;
import entidades.personas.*;
import entidades.personas.empleados.*;

public class Alberca extends Espacio {
    private double temperaturaAgua;
    private static int capacidadAlberca=20;  

    public Alberca (String nombre, Horario horario){
        super(nombre, capacidadAlberca, horario);
        this.temperaturaAgua=26.5;
        setEstado(Disponibilidad.DISPONIBLE);
    }

    public double getTemperaturaAgua(){
        return temperaturaAgua;
    }

    public void setTemperaturaAgua(double temperaturaAgua){ 
        this.temperaturaAgua = temperaturaAgua; 
    } 

    @Override 
    public boolean puedeIngresar(Persona persona){
        if (getEstado()!= Disponibilidad.DISPONIBLE){ 
            System.out.println("No se puede ingresar, la alberca no se encuentra disponible"); 
            return false; 
        }

        if (!hayEspacio()){
            return false; 
        }

        //aqui no se que modificar, o tipo pues le puse que si no tenia membresia, que no puede entrar
        if (persona.getMembresia() == null){ 
            System.out.println("Acceso denegado: " + persona.getNombre() + " no cuenta con una membresía activa."); 
            return false; 
        }

        return true;
    }

    public void iniciarLimpiezaDiaria(){
        System.out.println("La limpieza diaria comenzo");
        setEstado(Disponibilidad.ENMANTENIMIENTO);
    }
    //entre estos dos un temporizador para que salgan los mensajitos

    public void terminarLimpiezaDiaria(){
        //aqui algo que sale un mensajito
        System.out.println("La limpieza diaria termino. Alberca disponible");
        setEstado(Disponibilidad.DISPONIBLE);
    }

    //estos no se que mas podrian hacer
    public void iniciarLimpiezaProfunda(Servicio personal){
       System.out.println("Limpieza profunda iniciada");
        setEstado(Disponibilidad.ENMANTENIMIENTO);
    }

    public void terminarLimpiezaProfunda(){
        System.out.println("Limpieza profunda finalizada");
       setEstado(Disponibilidad.DISPONIBLE);
    }

}
