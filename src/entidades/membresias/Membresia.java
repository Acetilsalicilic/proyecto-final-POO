package entidades.membresias;

import entidades.actividades.TipoClase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class Membresia {
    protected String nombre;
    Set<TipoClase> clasesDisponibles;
    // TODO añadir espacios y tiempo límite
    protected boolean incluyeCoach;
    protected double costoBase;
    protected double descuentoTemporada;

    public Membresia(String nombre, boolean incluyeCoach, double costoBase) {
        this.nombre = nombre;
        this.incluyeCoach = incluyeCoach;
        this.costoBase = costoBase;
    }

    public double getDescuentoTemporada() {
        return descuentoTemporada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isIncluyeCoach() {
        return incluyeCoach;
    }

    public void setIncluyeCoach(boolean incluyeCoach) {
        this.incluyeCoach = incluyeCoach;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public void setDescuentoTemporada(double descuentoTemporada) {
        this.descuentoTemporada = descuentoTemporada;
    }
}
