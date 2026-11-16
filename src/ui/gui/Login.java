package ui.gui;

import entidades.sistema.Usuario;

import javax.swing.*;

public class Login extends JPanel {
    private JLabel title;
    private JPanel buttonPanel;
    private JTextField username_t;
    private JTextField passwd_t;
    private JButton login_b;

    private Usuario admin = new Usuario("admin", "admin");

    public Login(Runnable onSucessful, Runnable onFailure) {
        super();
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        add(buttonPanel);

        title = new JLabel("Iniciar sesión");
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

            if (admin.equals(user)) {
                onSucessful.run();
            } else {
                System.out.println("Admin: "+admin);
                System.out.println("New: "+user);
                onFailure.run();
            }
        });
    }
}
