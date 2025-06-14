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
            peparedStatmenet.close();
    }

    @Override
    public void modificar(Medico elemento) throws SQLException, ClassNotFoundException {
 
    }


    @Override
    public void eliminar(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        PreparedStatement ps = connection.prepareStatement("DELETE FROM MEDICO WHERE ID = ?");
        ps.setString(1, id);
        ps.executeUpdate();
        ps.close();
        connection.close();
    }

    @Override
    public Medico buscar(String id) throws SQLException, ClassNotFoundException {
        String ida;
        String nombre;
        String apellido;
        int costo;
        Medico aux = null;
        
        Connection connection=null;
        PreparedStatement peparedStatmenet=null;
        Medico mediocAux=null;
        Class.forName(DB_JDBC_DRIVER);
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        peparedStatmenet = connection.prepareStatement("SELECT * FROM MEDICO WHERE ID=?");
        peparedStatmenet.setString(1,id);
        ResultSet rs= peparedStatmenet.executeQuery();
        if (rs.next()) {
            ida = rs.getString("id");
            nombre = rs.getString("nombre");
            apellido = rs.getString("apellido");
            costo = rs.getInt("costo");
            aux = new Medico (ida, nombre, apellido, costo);
        }
        peparedStatmenet.close();
        return aux;
    }


    public ArrayList<Medico> buscarTodos() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        Medico medico = null;
        ArrayList<Medico> medicos = new ArrayList<>();
        
        String id;
        String nombre;
        String apellido;
        int costo;
        
        Class.forName(DB_JDBC_DRIVER);
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        preparedStatement = connection.prepareStatement("SELECT * FROM MEDICO");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            id = rs.getString("id");
            nombre = rs.getString("nombre");
            apellido = rs.getString("apellido");
            costo = rs.getInt("costo");
            medico = new Medico (id, nombre, apellido, costo);
            
            medicos.add(medico);
        }
        preparedStatement.close();
        return medicos;
    }
}
