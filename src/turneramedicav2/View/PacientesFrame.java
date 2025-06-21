package turneramedicav2.View;

import turneramedicav2.Entidades.Paciente;
import turneramedicav2.Persistencia.PacienteDAO;
import turneramedicav2.Servicio.PacienteController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PacientesFrame extends JFrame {

    private JTable tablaPacientes;
    private DefaultTableModel modeloTabla;
    private PacienteController controller;

    public PacientesFrame() {
        super("Gestión de Pacientes");

        controller = new PacienteController(new PacienteDAO());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Tabla
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Apellido"}, 0);
        tablaPacientes = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaPacientes);
        add(scrollPane, BorderLayout.CENTER);

        // Botonera
        JPanel panelBotones = new JPanel();
        JButton btnAgregar = new JButton("Agregar");
        JButton btnModificar = new JButton("Modificar");
        JButton btnEliminar = new JButton("Eliminar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);
        add(panelBotones, BorderLayout.SOUTH);

        // Eventos
        btnAgregar.addActionListener(e -> mostrarFormulario(null));
        btnModificar.addActionListener(e -> {
            int fila = tablaPacientes.getSelectedRow();
            if (fila >= 0) {
                int id = (int) modeloTabla.getValueAt(fila, 0);
                String nombre = (String) modeloTabla.getValueAt(fila, 1);
                String apellido = (String) modeloTabla.getValueAt(fila, 2);
                mostrarFormulario(new Paciente(id, nombre, apellido));
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un paciente para modificar.");
            }
        });

        btnEliminar.addActionListener(e -> {
            int fila = tablaPacientes.getSelectedRow();
            if (fila >= 0) {
                int id = (int) modeloTabla.getValueAt(fila, 0);
                String nombre = (String) modeloTabla.getValueAt(fila, 1);
                String apellido = (String) modeloTabla.getValueAt(fila, 2);
                controller.eliminarPaciente(new Paciente(id, nombre, apellido));
                cargarPacientes();
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un paciente para eliminar.");
            }
        });

        cargarPacientes();
    }

    private void cargarPacientes() {
        modeloTabla.setRowCount(0);
        List<Paciente> pacientes = controller.leerTodos(null);
        if (pacientes != null) {
            for (Paciente p : pacientes) {
                modeloTabla.addRow(new Object[]{p.getId(), p.getNombre(), p.getApellido()});
            }
        }
    }

    private void mostrarFormulario(Paciente paciente) {
        JTextField campoNombre = new JTextField();
        JTextField campoApellido = new JTextField();

        if (paciente != null) {
            campoNombre.setText(paciente.getNombre());
            campoApellido.setText(paciente.getApellido());
        }

        Object[] campos = {
                "Nombre:", campoNombre,
                "Apellido:", campoApellido
        };

        int opcion = JOptionPane.showConfirmDialog(this, campos,
                paciente == null ? "Agregar Paciente" : "Modificar Paciente", JOptionPane.OK_CANCEL_OPTION);

        if (opcion == JOptionPane.OK_OPTION) {
            String nombre = campoNombre.getText();
            String apellido = campoApellido.getText();

            if (paciente == null) {
                // ID ficticio, en un sistema real lo genera la base de datos
                int nuevoId = (int) (Math.random() * 10000);
                controller.guardarPaciente(new Paciente(nuevoId, nombre, apellido));
            } else {
                paciente.setNombre(nombre);
                paciente.setApellido(apellido);
                controller.modificarPaciente(paciente);
            }

            cargarPacientes();
        }
    }
}