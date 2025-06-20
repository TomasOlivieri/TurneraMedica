package turneramedicav2.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseH2 {
	
//	private static final String driver = "org.h2.Driver";
//	private static final String url = "jdbc:h2:tcp://localhost//D:/base_de_datos/ejemplo";
//	private static final String username = "sa";
//	private static final String passwd = "sa";
	
	private final String driver;
	private final String url;
	private final String username;
	private final String passwd;
	
	private Connection connection;
	
	protected BaseH2() {
		driver = "org.h2.Driver";
		url = "jdbc:h2:~/test";
		username = "sa";
		passwd = "";	
	}
	
	protected BaseH2(String driver, String url, String username, String passwd) {
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.passwd = passwd;
	}

	private final void cargarDriver() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.exit(0);
		}
	}
	
	private final void obtenerConexion() throws SQLException {
		try {
			connection = DriverManager.getConnection(url, username, passwd);
		} catch (SQLException e) {
			//e.printStackTrace();
			throw e;
		}
	}
	
	protected final void cerrarConexion() throws SQLException {
		try {
			connection.close();
		} catch (SQLException e) {
			//e.printStackTrace();
			throw e;
		}
	}
	
	protected final void updateDeleteInsertSql(String sql, Object... params) throws SQLException {
		PreparedStatement s;
		cargarDriver();
		obtenerConexion();
		try {
			s = preparedStatement_v20(sql, params);
			s.executeUpdate();
			s.close();
		} catch (SQLException e) {
			//e.printStackTrace();
			throw e;
		} finally {
			cerrarConexion();
		}
	}
	
	protected final ResultSet selectSql(String sql, Object... params) throws SQLException {
		ResultSet rs;
		cargarDriver();
		obtenerConexion();
		PreparedStatement s;
		try {
			s = preparedStatement_v20(sql, params);
			rs = s.executeQuery();
			//s.close();
			return rs;
		} catch (SQLException e) {
			//e.printStackTrace();
			throw e;
		} finally {
			//cerrarConexion();
		}
	}
	/*
	//Compatible con Java21 en adelante
	private PreparedStatement preparedStatement_v21(String dml, Object[] params) throws SQLException {
		try (PreparedStatement s = connection.prepareStatement(dml)) { //Try-with-resources!!!!
			int i=0;
			for (Object param: params) {
				switch (param) { //Switch por tipo de Clase!!!
					case Integer p -> s.setInt(i++, p);
					case String p -> s.setString(i++, p);
					case Double p -> s.setDouble(i++, p);
					case Long p -> s.setLong(i++, p);
				default -> throw new IllegalArgumentException("Unexpected value: " + param);
				}
			}
			return s;
		} 
	}*/

	//Compatible con Java20 para atras
	private PreparedStatement preparedStatement_v20(String dml, Object... params) throws SQLException {
		PreparedStatement s;
		s = connection.prepareStatement(dml);
		int i=1;
		for (Object param: params) {
			if (param instanceof Integer _param) s.setInt(i++, _param);
			else if (param instanceof String _param) s.setString(i++, _param); //Vean este caso!!
			else if (param instanceof Double _param) s.setDouble(i++, _param);
			else if (param instanceof Long) s.setLong(i++, (Long) param);
			else throw new IllegalArgumentException("Unexpected value: " + param);
		}
		return s;
	}
}