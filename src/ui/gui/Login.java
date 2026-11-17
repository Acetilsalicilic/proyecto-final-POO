package ui.gui;

import entidades.personas.Persona;
import entidades.personas.empleados.Administrador;
import entidades.sistema.Usuario;

import javax.swing.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Login extends JPanel {
    private JLabel title;
    private JPanel buttonPanel;
    private JTextField username_t;
    private JTextField passwd_t;
    private JButton login_b;

    private Usuario admin = new Usuario("admin", "admin");
    private Persona admin_p = new Administrador("Admin");

    public Login(Consumer<Persona> onSucessful, Runnable onFailure) {
        super();
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        add(buttonPanel);

        title = new JLabel("Iniciar sesión");
        title.setFont(GUI.TITLE_FONT);
        buttonPanel.add(title);

        username_t = new JTextField();
        buttonPanel.add(username_t);

        passwd_t = new JTextField();
        buttonPanel.add(passwd_t);

        login_b = new JButton("Login");
        buttonPanel.add(login_b);

        login_b.addActionListener(evt -> {
            String username = username_t.getText();
            String passwd = passwd_t.getText();
            Usuario user = new Usuario(username, passwd);

            username_t.setText("");
            passwd_t.setText("");

            if (admin.equals(user)) {
                onSucessful.accept(admin_p);
            } else {
                System.out.println("Admin: "+admin);
                System.out.println("New: "+user);
                onFailure.run();
            }
        });
    }
}
