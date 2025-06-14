package turneramedica.Persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import turneramedica.Entidades.Medico;


public interface ICRUD <T> {
    public void guardar(T elemento) throws SQLException, ClassNotFoundException;
    public void modificar(T elemento) throws SQLException, ClassNotFoundException;
    public void eliminar(String id) throws SQLException, ClassNotFoundException;
    public Medico buscar(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<T> buscarTodos() throws SQLException, ClassNotFoundException;
}
