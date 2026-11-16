package entidades.membresias;

import entidades.actividades.TipoClase;

import java.util.Set;

public abstract class Membresia {
    protected String nombre;
    Set<TipoClase> clasesDisponibles;
    // TODO añadir espacios y tiempo límite
    protected boolean incluyeCoach;
    protected double costoBase;
    protected double descuentoTemporada;
    protected PlazoPago plazoPago;

    public abstract double getDescuentoTemporada();
}
