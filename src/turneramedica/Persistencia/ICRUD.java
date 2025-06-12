package turneramedica.Persistencia;

import java.util.ArrayList;


public interface ICRUD <T>{
    public void guardar(T elemento);
    public void modificar(T elemento);
    public void eliminar(int id);
    public T buscar(int id);
    public ArrayList<T> buscarTodos();
}
