package turneramedica.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import turneramedica.Entidades.Medico;

public class VentanaMedicos extends JFrame {

    public VentanaMedicos(List<Medico> medicos) {
        setTitle("Lista de Médicos");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnas = {"ID", "Nombre", "Apellido", "Costo"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Medico m : medicos) {
            Object[] fila = {m.getId(), m.getNombre(), m.getApellido(), m.getCosto()};
            modelo.addRow(fila);
        }

        JTable tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);

        add(scrollPane, BorderLayout.CENTER);
    }
}

