package turneramedicav2.View;

import turneramedicav2.Entidades.Medico;
import turneramedicav2.Servicio.MedicoCotroller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    private MedicoCotroller controller;

    public LoginFrame() {
        super("Login - Turnera Médica");

        controller = new MedicoCotroller();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        userField = new JTextField();
        passField = new JPasswordField();
        loginButton = new JButton("Iniciar sesión");

        add(new JLabel("Usuario:"));
        add(userField);
        add(new JLabel("Contraseña:"));
        add(passField);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userField.getText();
                String pass = new String(passField.getPassword());

                Medico medico = controller.loginMedico(user, pass);
                if (medico != null) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "¡Bienvenido Dr. " + medico.getApellido() + "!");
                    new MainFrame(medico).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}