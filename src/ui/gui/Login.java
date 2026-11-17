package ui.gui;

import entidades.personas.Persona;
import entidades.personas.empleados.Administrador;
import entidades.sistema.Usuario;

import javax.swing.*;
import java.util.function.Consumer;

public class Login extends JPanel {
    private JPanel container = new JPanel();
    private JTextField user_t, passwd_t;
    private JButton inicio_b;

    // TODO esto debería estar en un servicio
    private Administrador admin = new Administrador("admin");
    private Usuario usr = new Usuario("admin", "admin");

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

            // TODO esto debería poder manejar más casos, y consultar usuario -> persona en una DB
            if (nuevo.equals(usr)) {
                enExito.accept(admin);
            } else {
                enFracaso.run();
            }
        });
        container.add(inicio_b);

        add(container);
    }
}
