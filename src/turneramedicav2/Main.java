package turneramedicav2;

import javax.swing.SwingUtilities;
import turneramedicav2.View.LoginFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}
