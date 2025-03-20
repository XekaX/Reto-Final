package controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import javax.security.auth.login.LoginException;

import modelo.Cliente;
import modelo.Pelicula;
import modelo.Trabajador;

public class DaoImplementacionMSql implements Dao {
	
	// Atributos
		private Connection con;
		private PreparedStatement stmt;
		
	//Sentencias SQL
		final String INSERTAR_CLIENTE = "INSERT INTO propietario (DNI, NOMBRE, CONTRASENIA) VALUES (?,?,?)";
		
		
	private void openConnection() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tartangaPrimeVideo?serverTimezone=Europe/Madrid&useSSL=false", "root",
					"abcd*1234");
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
		}
	}
	
	private void closeConnection() throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (con != null)
			con.close();
	}

	@Override
	public void login(Trabajador trabajador) throws LoginException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void altaTrabajador(Trabajador trab) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Trabajador buscarTrabajador(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarTrabajador(Trabajador id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarTrabajador(Trabajador id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void añadirPelicula(Pelicula peli) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pelicula buscarPelicula(String idP) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarPelicula(Pelicula copelic) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarPeliculas(Pelicula peli) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Pelicula> listarPeliculas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Pelicula> listarPeliculasCompradas(Pelicula peli) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void altaClientes(Cliente clien) {
		openConnection();
		try {
			stmt = con.prepareStatement(INSERTAR_CLIENTE);
			stmt.setString(1, clien.getDni());
			stmt.setString(2, clien.getNombre());
			stmt.setDate(3, Date.valueOf(clien.getContrasenia()));
			System.out.println("QUERY: " + stmt);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error SQL Exception");
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}


}


