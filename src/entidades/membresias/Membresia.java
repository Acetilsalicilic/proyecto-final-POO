package entidades.membresias;

import entidades.actividades.TipoClase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Membresia {
    private String nombre;
    protected double costoBase;
    protected boolean incluyeCoach;
    protected double descuentoTemporada;
    // TODO añadir espacios y tiempo límite

    Set<TipoClase> clasesDisponibles;

    public Membresia(String nombre, double costoBase, boolean incluyeCoach) {
        this.nombre = nombre;
        this.costoBase = costoBase;
        this.incluyeCoach = incluyeCoach;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDescuentoTemporada() {
        return descuentoTemporada;
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
