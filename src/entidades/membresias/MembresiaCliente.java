package entidades.membresias;

public class MembresiaCliente {
    private Membresia membresia;
    private PlazoPago plazoPago;

    public MembresiaCliente(Membresia membresia, PlazoPago plazoPago) {
        this.membresia = membresia;
        this.plazoPago = plazoPago;
    }

    public MembresiaCliente(Membresia membresia) {
        this.membresia = membresia;
    }

    public double calcularCostoTotal() {
        throw new UnsupportedOperationException("No implementado");
    }

    public Membresia getMembresia() { return membresia; }
    public void setMembresia(Membresia m) { this.membresia = membresia; }
}
