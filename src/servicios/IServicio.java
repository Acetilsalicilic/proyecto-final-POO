package servicios;

import entidades.personas.Persona;
import ui.gui.componentes.ISujeto;

import java.util.List;

public interface IServicio<T> extends ISujeto {
    public List<T> getTodos();
    public void agregar(T e);
}
