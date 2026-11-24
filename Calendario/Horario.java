package Calendario;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.List;

public class Horario {
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private LocalDate fecha;
    private List <Clase> clasesAgendadas;
    private List <Mantenimiento> mantenimientosAgendados;

    public Horario (LocalTime horaInicio, LocalTime horaFin, LocalDate fecha){
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
        this.fecha=fecha;
    }

    


}
