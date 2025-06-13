package turneramedica.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import turneramedica.Controller.MedicoController;
import turneramedica.Entidades.Medico;

public class PantallaInicio extends JFrame {
    MedicoController medicoController;
    
    public PantallaInicio() {
        medicoController = new MedicoController();
        
        setTitle("Turnera Médica");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JButton btnMostrarMedicos = new JButton("Mostrar médicos disponibles");       
        
        btnMostrarMedicos.addActionListener(e -> {
        try {
            ArrayList<Medico> medicos = (ArrayList<Medico>) medicoController.obtenerTodosLosMedicos();
            VentanaMedicos ventanaMedicos = new VentanaMedicos(medicos);
            ventanaMedicos.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener médicos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        });
        
        setLayout(new BorderLayout());
        add(btnMostrarMedicos, BorderLayout.CENTER);
    }
}
