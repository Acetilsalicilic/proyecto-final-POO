package Espacios;

import Calendario.*;
import entidades.personas.Persona;

import java.util.HashSet;
import java.util.Set;

public class Espacio {
    private String nombre;
    private int capacidad;

    private Disponibilidad estado;
    private Set<Persona> personasPresentes;
    private Horario horario;

    public Espacio (String nombre, int capacidad){
        this.nombre= nombre;
        this.capacidad=capacidad;
        this.estado=Disponibilidad.DISPONIBLE;
        this.personasPresentes =new HashSet<>();
    }

    public boolean hayEspacio(){
        if (getPersonasPresentes().size()>= capacidad){
            System.out.println("El espacio ya esta lleno");
            System.out.println("Cantidad de personas: "+ getPersonasPresentes().size());
            return false;
        }else{
            System.out.println("Si hay espacio :D");
            return true;
        }
    }

    public String getNombre(){
        return nombre;
    }
    
    public Disponibilidad getEstado(){
        return estado;
    }

    public Set<Persona> getPersonasPresentes() {
        return personasPresentes;
    }

    public boolean puedeIngresar(){
        if (!(estado==Disponibilidad.DISPONIBLE)){
            System.out.println("En este momento no se encuentra disponible");
            System.out.println("Estado: " + getEstado());
            return false;

        }else{
            System.out.println("Disponible :D");
            return true;
        }
    }

    public void registrarEntrada(Persona persona){
        if (hayEspacio() && puedeIngresar()){
            //tipo un tipo hora de entrada?
            //aqui no se tipo en donde registramos la entrada de alguien?
        }
    }

    public void registrarSalida(Persona persona){
        //salio a tal hora 
    }

    public void iniciarMantenimiento(Persona persona){
        //aqui tambien no se en donde se registra que comenzo el mantenimiento
        estado=Disponibilidad.ENMANTENIMEINTO;
    }

    public void finalizarMantenimiento(){
        //aqui pues solo imprimiria no? y lo del mensajito
        System.out.println("Mantenimiento finalizado");
        estado=Disponibilidad.DISPONIBLE;
    }

}
