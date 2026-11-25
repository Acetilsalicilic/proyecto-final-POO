package ui.gui;

import entidades.personas.Persona;
import entidades.personas.empleados.Administrador;
import entidades.sistema.Usuario;
import servicios.ServicioUsuarios;

import javax.swing.*;
import java.util.function.Consumer;

public class Login extends JPanel {
    private JPanel container = new JPanel();
    private JTextField user_t, passwd_t;
    private JButton inicio_b;

    public Login(Consumer<Persona> enExito, Runnable enFracaso) {
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        var titulo_l = new JLabel("Inicio de sesión");
        titulo_l.setFont(GUI.FUENTE_TITULO);
        container.add(titulo_l);

        user_t = new JTextField();
        passwd_t = new JTextField();

        container.add(user_t);
        container.add(passwd_t);

        inicio_b = new JButton("Ingresar");
        inicio_b.addActionListener(evt -> {
            String user = user_t.getText();
            String passwd = passwd_t.getText();

            user_t.setText("");
            passwd_t.setText("");

            var nuevo = new Usuario(user, passwd);

            var verificacion = ServicioUsuarios.instancia().verificar(nuevo);
            if (verificacion.isEmpty()) {
                enFracaso.run();
            } else {
                enExito.accept(verificacion.get());
            }

        });
        container.add(inicio_b);

        add(container);
    }
}
