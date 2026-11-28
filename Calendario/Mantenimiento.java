package Calendario;

import entidades.personas.empleados.Servicio;
import java.time.LocalTime;

public class Mantenimiento extends Actividad {
    private Servicio personalEncargado; // Conexión con Empleados (compañero)
    private TipoMantenimiento tipoMantenimiento;

    public Mantenimiento(TipoMantenimiento tipoMantenimiento, Servicio personalEncargado, LocalTime horaInicio, LocalTime horaFin) {
        super("Mantenimiento: " + tipoMantenimiento.name(), horaInicio, horaFin);
        this.tipoMantenimiento = tipoMantenimiento;
        this.personalEncargado = personalEncargado;
    }

    public Servicio getPersonalEncargado() {
        return personalEncargado;
    }

    public TipoMantenimiento getTipoMantenimiento() {
        return tipoMantenimiento;
    }
}