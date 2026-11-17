package entidades.personas.empleados;

import entidades.actividades.Clase;
import entidades.actividades.TipoClase;

import java.util.List;

public class Entrenador extends Empleado {
    TipoClase tipoClase;
    List<Clase> clases;

    public Entrenador(String nombre) {
        super(nombre);
    }
}
