package entidades.personas.empleados;

import entidades.sistema.Usuario;
import entidades.personas.Persona;

import java.time.LocalTime;

public class Empleado extends Persona {
    static double salarioBase;

    protected String puesto;
    protected double salario;
    LocalTime horaEntrada;
    LocalTime horaSalida;
    Usuario usuario;

    public Empleado(String nombre) {
        super(nombre);
    }
}
