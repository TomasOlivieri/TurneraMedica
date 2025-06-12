package turneramedica.Persistencia;

import java.util.ArrayList;
import turneramedica.Entidades.Medico;


public class DAOMedico implements ICRUD<Medico>{
    // jdbc:h2:~/Users/franciscohuber/Desktop/base de datos
    private String DB_JDBC_DRIVER ="org.h2.Driver";
    private String DB_URL="jdbc:h2:~/BaseDeDatos";
    private String DB_USER="sa";
    private String DB_PASSWORD="";

    @Override
    public void guardar(Medico elemento) {

    }

    @Override
    public void modificar(Medico elemento) {
 
    }


    @Override
    public void eliminar(int id) {

    }

    @Override
    public Medico buscar(int id) {
        Medico retorno = new Medico ("1", "tomas", "olivieri", 1000);
        return retorno;
    }


    public ArrayList<Medico> buscarTodos() {
        ArrayList retorno = new ArrayList<Medico>();
        return retorno;
    }

    public Medico buscarPorCredenciales(String usuario, String contraseña) {
        Medico retorno = new Medico ("1", "tomas", "olivieri", 1000);
        return retorno;
    }
}
