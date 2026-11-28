package Calendario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Horario{
    private LocalTime horaApertura;
    private LocalTime horaCierre;
    private LocalDate fecha;
    private List<Clase> clasesAgendadas;
    private List<Mantenimiento> mantenimientosAgendados;

    public Horario(LocalTime horaApertura, LocalTime horaCierre, LocalDate fecha) {
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.fecha = fecha;
        this.clasesAgendadas = new ArrayList<>();
        this.mantenimientosAgendados = new ArrayList<>();
    }

    public LocalTime getHoraApertura(){ 
        return horaApertura; 
    }
    public LocalTime getHoraCierre(){ 
        return horaCierre; 
    }
    public LocalDate getFecha(){ 
        return fecha; 
    }
    public List<Clase> getClasesAgendadas(){ 
        return clasesAgendadas; 
    }
    public List<Mantenimiento> getMantenimientosAgendados(){ 
        return mantenimientosAgendados; 
    }

    public boolean agregarClase(Clase nuevaClase) {
        if (validarEmpalme(nuevaClase)) {
            System.out.println("Error: La clase " + nuevaClase.getNombre() +" se empalma con otro evento de " + nuevaClase.getHoraInicio() + " - " + nuevaClase.getHoraFin());
            return false;
        }

        getClasesAgendadas().add(nuevaClase);
        System.out.println("Clase '" + nuevaClase.getNombre() + "' agendada exitosamente.");
        return true;
    }

    public boolean agregarMantenimiento(Mantenimiento nuevoMant) {
        if (validarEmpalme(nuevoMant)) {
            System.out.println("Error: El mantenimiento se empalma con algo mas");
            return false;
        }
        getMantenimientosAgendados().add(nuevoMant);
        System.out.println("Mantenimiento agendado exitosamente.");
        return true;
    }

    private boolean validarEmpalme(Actividad nueva) {
        for (Clase c : getClasesAgendadas()) {
            if (c.seEmpalmaCon(nueva)) {
                return true;
            }
        }

        for (Mantenimiento m : getMantenimientosAgendados()) {
            if (m.seEmpalmaCon(nueva)) {
                return true;
            }
        }
        return false;
    }

    public boolean estaEnHorarioLibre(LocalTime horaActual) {
        for (Clase c : getClasesAgendadas()) {
            if (c.estaEnCurso(horaActual)) return false;
        }
        for (Mantenimiento m : getMantenimientosAgendados()) {
            if (m.estaEnCurso(horaActual)) return false;
        }
        return true;
    }


}