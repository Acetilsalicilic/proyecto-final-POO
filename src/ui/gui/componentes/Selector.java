package ui.gui.componentes;

import servicios.IServicio;
import servicios.ISuscriptor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Selector<T> extends JComboBox<String> implements ISuscriptor {
    private List<T> lista = new ArrayList<>();
    private IServicio<T> servicio;
    private Function<T, String> extraerEtiqueta;

    public Selector(IServicio<T> servicio, Function<T, String> extraerEtiqueta) {
        this.servicio = servicio;
        this.extraerEtiqueta = extraerEtiqueta;

        servicio.suscribir(this);
        notificar();
    }

    @Override
    public void notificar() {
        removeAllItems();
        lista = servicio.getTodos();
        for (var e : lista)
            addItem(extraerEtiqueta.apply(e));
    }

    public Optional<T> getSeleccionado() {
        int idx = getSelectedIndex();

        if (idx < 0)
            return Optional.empty();
        else
            return Optional.of(lista.get(idx));
    }
}
