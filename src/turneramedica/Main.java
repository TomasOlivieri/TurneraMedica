package turneramedica;

import java.sql.SQLException;
import turneramedica.Entidades.Medico;
import turneramedica.Persistencia.DAOMedico;

public class Main {

    public static void main(String[] args) {
        Medico m = new Medico ("1", "Carlos", "Bago", 15000);
        DAOMedico dao = new DAOMedico ();
        try {
            dao.guardar(m);
        } catch (SQLException ex) {
            System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ClassNotFoundException ex) {
            System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
