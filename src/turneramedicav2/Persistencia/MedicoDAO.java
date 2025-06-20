package turneramedicav2.Persistencia;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.ResultSet;
import turneramedicav2.Entidades.Medico;


public class MedicoDAO extends BaseH2{
    
    public MedicoDAO () {
        super();
    }
    
    
    public Medico leerPorId(Integer id) throws IOException, ClassNotFoundException, SQLException {
	String sql = "select ID, NOMBRE, APELLIDO, USER, PASS, COSTO from MEDICO where id = ?";
	ResultSet rs = selectSql(sql, id);
	if (rs.first()) {
            Medico p = new Medico(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                                  rs.getString(5), rs.getInt(6));
	cerrarConexion();
	return p;
	} else {
            return null;
	}
    }
    
    public int verificarCredenciales (String user, String pass) throws SQLException {
        int retorno;
        String sql = "SELECT ID FROM MEDICO WHERE USER = ? AND PASS = ?";
        ResultSet rs = selectSql(sql, user, pass);
        if (rs.first()) {
            retorno = rs.getInt(1);
	cerrarConexion();
	return retorno;
	} else {
            return 0;
	}
    }
}
