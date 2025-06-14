package turneramedica.View;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

class ButtonEditor extends DefaultCellEditor {
    private JButton button;
    private String id;
    private boolean clicked;
    private int fila;
    private VentanaMedicos ventana;

    public ButtonEditor(JCheckBox checkBox, VentanaMedicos ventana) {
        super(checkBox);
        this.ventana = ventana;
        button = new JButton("Eliminar");
        button.addActionListener(e -> fireEditingStopped());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        id = (String) table.getValueAt(row, 0);
        fila = row;
        clicked = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (clicked) {
            ventana.eliminarMedico(id, fila);
        }
        clicked = false;
        return "Eliminar";
    }

    @Override
    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing();
    }
}
