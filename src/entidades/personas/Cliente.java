package entidades.personas;

import entidades.membresias.MembresiaCliente;
import entidades.personas.empleados.Coach;

public class Cliente extends Persona {
    public Cliente(String nombre, MembresiaCliente membresia, Coach coach) {
        super(nombre, membresia, coach);
    }
}
