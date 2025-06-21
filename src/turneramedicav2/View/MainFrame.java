package turneramedicav2.View;

import turneramedicav2.Entidades.Medico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private Medico medico;

    public MainFrame(Medico medico) {
        super("Panel Principal - Turnera Médica");

        this.medico = medico;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel bienvenidaLabel = new JLabel("Bienvenido Dr. " + medico.getApellido(), SwingConstants.CENTER);
        bienvenidaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(bienvenidaLabel, BorderLayout.NORTH);

        JButton gestionarPacientesButton = new JButton("Gestionar Pacientes");
        add(gestionarPacientesButton, BorderLayout.CENTER);

        gestionarPacientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la ventana de gestión de pacientes
                new PacientesFrame().setVisible(true);
            }
        });
    }
}