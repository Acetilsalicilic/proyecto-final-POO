package entidades.actividades;

import entidades.personas.Persona;

import java.util.ArrayList;
import java.util.List;

public class Clase extends Actividad {
    List<Persona> personasInscritas = new ArrayList<>();
    TipoClase tipoClase;
    int cupoMaximo;

    public Clase(TipoClase tipoClase, int cupoMaximo) {
        this.tipoClase = tipoClase;
        this.cupoMaximo = cupoMaximo;
    }
}
