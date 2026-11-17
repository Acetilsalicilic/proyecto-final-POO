package ui.gui.componentes;

import servicios.IServicio;

import javax.swing.*;

public abstract class Tabla<T> extends JTable implements ISuscriptor {
    protected ModeloTabla<T> modelo;
    protected final IServicio<T> servicio;

    public Tabla(IServicio<T> servicio) {
        this.servicio = servicio;
        servicio.suscribir(this);

        // Primera actualización de los datos - agrega el primer modelo
        notificar();
    }

}
