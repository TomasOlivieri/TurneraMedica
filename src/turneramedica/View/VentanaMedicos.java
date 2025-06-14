package turneramedica.View;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import turneramedica.Controller.MedicoController;
import turneramedica.Entidades.Medico;

public class VentanaMedicos extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;
    private MedicoController medicoController;

    public VentanaMedicos() {
        setTitle("Lista de Médicos");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        medicoController = new MedicoController();

        String[] columnas = {"ID", "Nombre", "Apellido", "Costo", "Acción"};
        modelo = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4; // Solo la columna de botones es editable
            }
        };

        try {
            for (Medico m : medicoController.obtenerTodosLosMedicos()) {
                modelo.addRow(new Object[]{m.getId(), m.getNombre(), m.getApellido(), m.getCosto(), "Eliminar"});
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.getLogger(VentanaMedicos.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        tabla = new JTable(modelo);
        tabla.getColumn("Acción").setCellRenderer(new ButtonRenderer());
        tabla.getColumn("Acción").setCellEditor(new ButtonEditor(new JCheckBox(), this));

        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void eliminarMedico(String id, int fila) {
        try {
            medicoController.eliminarMedicoPorId(id);
            modelo.removeRow(fila);
            JOptionPane.showMessageDialog(this, "Médico eliminado correctamente.");
        } catch (HeadlessException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar médico: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}