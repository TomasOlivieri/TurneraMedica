package turneramedica.Persistencia;

import turneramedica.Entidades.Medico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;



public class DAOMedico implements ICRUD<Medico>{
    // jdbc:h2:~/Users/franciscohuber/Desktop/base de datos
    private String DB_JDBC_DRIVER ="org.h2.Driver";
    private String DB_URL="jdbc:h2:~/BaseDeDatos";
    private String DB_USER="sa";
    private String DB_PASSWORD="";

    @Override
    public void guardar(Medico elemento) throws SQLException, ClassNotFoundException {
            Connection connection=null;
            PreparedStatement peparedStatmenet=null;
            Class.forName(DB_JDBC_DRIVER); // Carga el controlador JDBC de H2 en memoria
            connection = (Connection) DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            peparedStatmenet=connection.prepareStatement("INSERT INTO MEDICO (id, nombre, apellido, costo) VALUES(?,?,?,?)");
            peparedStatmenet.setString(1,elemento.getId());
            peparedStatmenet.setString(2,elemento.getNombre());
            peparedStatmenet.setString(3, elemento.getApellido());
            peparedStatmenet.setInt(4,elemento.getCosto());
            int result=peparedStatmenet.executeUpdate();
            System.out.println("Medico guardado exitosamente:"+result);
    }

    @Override
    public void modificar(Medico elemento) throws SQLException, ClassNotFoundException {
 
    }


    @Override
    public void eliminar(int id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public Medico buscar(int id)  throws SQLException, ClassNotFoundException {
        Medico retorno = new Medico ("1", "tomas", "olivieri", 1000);
        return retorno;
    }


    public ArrayList<Medico> buscarTodos() throws SQLException, ClassNotFoundException {
        ArrayList retorno = new ArrayList<Medico>();
        return retorno;
    }
}
