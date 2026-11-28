package ui.gui.admin.usuarios;

import entidades.personas.Persona;
import entidades.sistema.Usuario;
import servicios.ServicioPersona;
import servicios.ServicioUsuarios;
import ui.gui.componentes.PantallaCampos;
import ui.gui.componentes.Selector;

import javax.swing.*;

public class PantallaCrearUsuario extends PantallaCampos {
    Selector<Persona> selectorPersona;
    public PantallaCrearUsuario(int ancho) {
        super(ancho);

        selectorPersona = new Selector<>(ServicioPersona.getInstance(), Persona::getNombre);

        addFila("Persona", selectorPersona);
        addCampoTexto("Usuario");
        addCampoTexto("Contraseña");

        addBoton("Registrar usuario", () -> {
            var optPersona = selectorPersona.getSeleccionado();

            if (optPersona.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: No se ha seleccionado ninguna persona");
                return;
            }

            var persona = optPersona.get();

            if (ServicioUsuarios.instancia().existePersona(persona)) {
                JOptionPane.showMessageDialog(this, "Error: La persona ya tiene un registro");
                return;
            }

            String nombre = getCampoTexto("Usuario").getText();
            String contraseña = getCampoTexto("Contraseña").getText();

            if (ServicioUsuarios.instancia().existeUsuario(nombre)) {
                JOptionPane.showMessageDialog(this, "Error: El nombre de usuario ya está en uso");
                return;
            }

            Usuario nuevo = new Usuario(nombre, contraseña);

            ServicioUsuarios.instancia().agregar(nuevo, persona);

            JOptionPane.showMessageDialog(this, "Usuario creado con éxito");
        });
    }
}
