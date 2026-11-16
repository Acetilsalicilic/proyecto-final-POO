package entidades.membresias;

public enum PlazoPago {
    MENSUAL(0.0), ANUAL(15.0);

    private double descuento;
    private PlazoPago(double descuento) {
        this.descuento = descuento;
    }
}
