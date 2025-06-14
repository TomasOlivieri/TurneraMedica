package turneramedica.View;

import javax.swing.*;
import java.awt.*;
import turneramedica.Controller.MedicoController;


public class PantallaInicio extends JFrame {
    MedicoController medicoController;
    JPanel panel;
    
    public PantallaInicio() {
        medicoController = new MedicoController();
        
        setTitle("Turnera Médica");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  
        
        JPanel panel = new JPanel();

        
        JButton btnMostrarMedicos = new JButton("Mostrar médicos disponibles");       
        JButton btnAgregarMedico = new JButton("Agregar Médico");
        
        btnMostrarMedicos.addActionListener(e -> {
        try {
            VentanaMedicos ventanaMedicos = new VentanaMedicos();
            ventanaMedicos.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener médicos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        });
        
        
        btnAgregarMedico.addActionListener(e -> {
            VentanaAgregarMedico ventanaAgregar = new VentanaAgregarMedico(() -> {
                this.setVisible(true);
            });
            ventanaAgregar.setVisible(true);
            this.setVisible(false);
        });
        
        panel.add(btnMostrarMedicos);
        panel.add(btnAgregarMedico);
        add(panel, BorderLayout.CENTER);
    }
}
