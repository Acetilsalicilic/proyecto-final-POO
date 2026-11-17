package entidades.membresias;

public class MembresiaDummy extends Membresia {
    public MembresiaDummy(String nombre) {
        super(nombre, true, 100.0);
    }
    public MembresiaDummy() {
        this("Dummy" );
    }
}
