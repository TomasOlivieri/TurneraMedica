package turneramedicav2.Persistencia;

import java.sql.SQLException;
import java.io.IOException;
import java.util.List;

public interface ICRUD <T>{
    public void grabar(T t) throws IOException, SQLException;
    public T leerPorId(Integer id) throws IOException, ClassNotFoundException, SQLException;
    public List<T> leerTodos() throws SQLException;
    public void modificar(T t)  throws SQLException;
    public void eliminar (T t)  throws SQLException;
}
