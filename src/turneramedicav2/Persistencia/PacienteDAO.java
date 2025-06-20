package turneramedicav2.Persistencia;

import java.io.IOException;
import turneramedicav2.Entidades.Paciente;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;


public class PacienteDAO extends BaseH2 implements ICRUD<Paciente> {
    
    public PacienteDAO() {
	super();
    }

    @Override
    public void grabar(Paciente entity) throws SQLException {
        String sql = "INSERT INTO PACIENTE (ID,NOMBRE,APELLIDO) VALUES (?,?,?)"; 
        updateDeleteInsertSql(sql, entity.getId(), entity.getNombre(), entity.getApellido());
    }

    @Override
    public Paciente leerPorId(Integer id) throws IOException, ClassNotFoundException, SQLException {
	String sql = "select ID, NOMBRE, APELLIDO from PERSONAS where id = ?";
	ResultSet rs = selectSql(sql, id);
	if (rs.first()) {
            Paciente p = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3));
	cerrarConexion();
	return p;
	} else {
            return null;
	}
    }

    @Override
    public List<Paciente> leerTodos() throws SQLException {
	String sql = "select ID, NOMBRE, APELLIDO from PERSONAS";
	ResultSet rs = super.selectSql(sql);
	List<Paciente> retorno = new ArrayList<>();
	while (rs.next()) {
            retorno.add(new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3)));
	}
	cerrarConexion();
	return retorno;
    }

    @Override
    public void modificar(Paciente t)  throws SQLException{
        String sql = "update from PERSONAS set nombre=?, apellido=?, where id = ? ";
        updateDeleteInsertSql(sql,
        t.getNombre(),
        t.getApellido(),
        t.getId());
    }
    

    @Override
    public void eliminar(Paciente entity) throws SQLException {
        String sql = "DELETE * FROM PACIENTE WHERE = ?";
        updateDeleteInsertSql(sql, entity.getId(), entity.getNombre(), entity.getApellido());
    }
}
