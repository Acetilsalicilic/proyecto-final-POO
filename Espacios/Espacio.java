package Espacios;

import Calendario.*;
import entidades.personas.Persona;

import java.util.HashSet;
import java.util.Set;

public abstract class Espacio {
    private String nombre;
    private int capacidad;

    private Disponibilidad estado;
    private Set<Persona> personasPresentes;
    private Horario horario;




    public Espacio (String nombre, int capacidad, Horario horario){
        this.nombre= nombre;
        this.capacidad=capacidad;
        this.estado=Disponibilidad.DISPONIBLE;
        this.personasPresentes =new HashSet<>();
        this.horario=horario;
    }

    



    public String getNombreEspacio(){
        return nombre;
    }

    public Disponibilidad getEstado(){
        return estado;
    }

    public void agregarPersona(Persona persona){
        getPersonasPresentes.add(persona);
    }

    public void setEstado(Disponibilidad estado){
        this.estado=estado;
    }

    public Set<Persona> getPersonasPresentes() {
        return personasPresentes;
    }

    public void eliminarPersona(Persona persona){
        personasPresentes.remove(persona);
    }

    public boolean contienePersona(Persona persona){
        return personasPresentes.contains(persona);
    }

    public int getCapacidad() {
        return capacidad; 
    }

    public Horario getHorario(){
        return horario;
    }





    public abstract boolean puedeIngresar(Persona persona);

    public boolean hayEspacio(){
        if (getPersonasPresentes().size()>= getCapacidad()){
            System.out.println("El espacio ya esta lleno");
            System.out.println("Cantidad de personas: "+ getPersonasPresentes().size()+ " / "+getCapacidad());
            return false;
        }else{
            System.out.println("Si hay espacio :D");
            return true;
        }
    }

    public boolean registrarEntrada(Persona persona){
        if (getEstado()!=Disponibilidad.DISPONIBLE){
            System.out.println("En este momento no se encuentra disponible");
            System.out.println("Estado: " + getEstado());
            return false;
        }

        if (hayEspacio() && puedeIngresar(persona)){
            agregarPersona(persona);
            System.out.println("Acceso concedido. " + persona.getNombre() + " ha ingresado a " + getNombreEspacio());
            return true;
        }

        return false;
    }

    public boolean registrarSalida(Persona persona){
        if (contienePersona(persona)) {
            eliminarPersona(persona);
            System.out.println(persona.getNombre() + " ha salido de " + getNombreEspacio());
            return true;
        }

        System.out.println("La persona no se encontraba registrada dentro de " + getNombreEspacio());
        return false;
    }

    public void iniciarMantenimiento(Servivio personal){
        setEstado(Disponibilidad.ENMANTENIMIENTO);
    }

    public void finalizarMantenimiento(){
        System.out.println("Mantenimiento finalizado");
        setEstado(Disponibilidad.DISPONIBLE);
    }


}
