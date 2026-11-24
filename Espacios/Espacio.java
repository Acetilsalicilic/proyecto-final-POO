package Espacios;

import Calendario.*;
import java.util.Set;

public class Espacio {
    private String nombre;
    private int capacidad;

    private enum disponibilidad{
        DISPONIBLE,
        ENMANTENIMEINTO,
        LLENA,
        HAYCLASE
    }

    private disponibilidad estado;
    private Set<Personas> personasPresentes;
    private Horario horario;


    

}
