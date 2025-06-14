package turneramedica.View;

import javax.swing.*;
import java.awt.*;
import turneramedica.Controller.MedicoController;
import turneramedica.Entidades.Medico;

public class VentanaAgregarMedico extends JFrame {
    private JTextField txtId, txtNombre, txtApellido, txtCosto;
    private MedicoController medicoController;
    private Runnable onMedicoAgregado; // Callback para actualizar la tabla si se desea

    public VentanaAgregarMedico(Runnable onMedicoAgregado) {
        this.onMedicoAgregado = onMedicoAgregado;
        medicoController = new MedicoController();

        setTitle("Agregar Médico");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("ID:"));
        txtId = new JTextField();
        add(txtId);

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        add(txtApellido);

        add(new JLabel("Costo:"));
        txtCosto = new JTextField();
        add(txtCosto);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarMedico());
        add(btnGuardar);
    }

    private void guardarMedico() {
        try {
            String id = txtId.getText().trim();
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            int costo = Integer.parseInt(txtCosto.getText().trim());

            Medico nuevo = new Medico(id, nombre, apellido, costo);
            medicoController.guardarMedico(nuevo);

            JOptionPane.showMessageDialog(this, "Médico agregado correctamente.");
            if (onMedicoAgregado != null) onMedicoAgregado.run();
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar médico: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
