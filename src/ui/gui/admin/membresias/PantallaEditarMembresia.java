package ui.gui.admin.membresias;

import entidades.membresias.Membresia;
import ui.gui.componentes.PantallaCampos;

public class PantallaEditarMembresia extends PantallaCampos {
    private Membresia membresia;
    private String[] etiquetas = {"Nombre", "Costo base", "¿Incluye coach?", "Descuento de temporada (número)"};
    public PantallaEditarMembresia(int ancho, Runnable afterGuardar) {
        super(ancho);

        addCampoTexto(etiquetas[0]);
        addCampoTexto(etiquetas[1]);
        addCheck(etiquetas[2]);
        addCampoTexto(etiquetas[3]);
        // TODO añadir selector de clases disponibles

        addBoton("Guardar", () -> {
            String nombre = getCampoTexto(etiquetas[0]).getText();
            double costoBase = Double.parseDouble(getCampoTexto(etiquetas[1]).getText());
            boolean incluyeCoach = getCheckBox(etiquetas[2]).isSelected();
            double dctoTemporada = Double.parseDouble(getCampoTexto("Descuento de temporada (número)").getText());

            membresia.setNombre(nombre);
            membresia.setCostoBase(costoBase);
            membresia.setIncluyeCoach(incluyeCoach);
            membresia.setDescuentoTemporada(dctoTemporada);

            asignarValores();

            afterGuardar.run();
        });
    }
    public void editarMembresia(Membresia membresia) {
        this.membresia = membresia;
        asignarValores();
    }
    private void asignarValores() {
        setTextoCampo(etiquetas[0], membresia.getNombre());
        setTextoCampo(etiquetas[1], membresia.getCostoBase());
        setCheck(etiquetas[2], membresia.isIncluyeCoach());
        setTextoCampo(etiquetas[3], membresia.getDescuentoTemporada());
    }
}
