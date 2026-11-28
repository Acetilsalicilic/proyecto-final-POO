package Calendario;

import java.time.LocalTime;

public abstract class Actividad {
    protected String nombre;
    protected LocalTime horaInicio;
    protected LocalTime horaFin;

    public Actividad(String nombre, LocalTime horaInicio, LocalTime horaFin) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraInicio (LocalTime nuevaHora){
        this.horaInicio=nuevaHora;
    }


    public void setHoraFin (LocalTime nuevaHora){
        this.horaFin=nuevaHora;
    }

    public boolean seEmpalmaCon(Actividad otraActividad) {
        boolean estaEmpiezaAntesDeQueTermineLaOtra = getHoraInicio().isBefore(otraActividad.getHoraFin());
        boolean laOtraEmpiezaAntesDeQueTermineEsta = otraActividad.getHoraInicio().isBefore(getHoraFin());

        return  estaEmpiezaAntesDeQueTermineLaOtra && laOtraEmpiezaAntesDeQueTermineEsta;
    }

    public boolean estaEnCurso(LocalTime horaActual) {
        boolean yaEmpezo = !horaActual.isBefore(getHoraInicio());

        boolean noHaTerminado = horaActual.isBefore(getHoraFin());

        return yaEmpezo && noHaTerminado;
    }

    public void reprogramar(LocalTime nuevaInicio, LocalTime nuevaFin) {
        setHoraInicio(nuevaInicio);
        setHoraFin(nuevaFin);
    }
    
}