package controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import excepciones.LoginException;
import modelo.Cliente;
import modelo.Genero;
import modelo.Pelicula;
import modelo.Trabajador;
import modelo.Tipo;
import modelo.Usuario;

public class DaoImplementacionMSql implements Dao {

	// Atributos
	private Connection con;
	private PreparedStatement stmt;


	//Sentencias SQL
	final String INSERTAR_CLIENTE = "INSERT INTO CLIENTE (DNI, NOMBRE, CONTRASENIA) VALUES (?,?,?)";
	final String INSERTAR_TRABAJADOR ="INSERT INTO TRABAJADOR (ID_T, CONTRASENIA, NOMBRE, SUELDO, TIPO) VALUES (?,?,?,?,?)";
	final String LOGIN_TRABAJADOR = "Select * from TRABAJADOR where NOMBRE = ? and CONTRASENIA = ?";
	final String ELIMINAR_TRABAJADOR = "DELETE from TRABAJADOR where ID_T=?";
	final String MODIFICAR_TRABAJADOR = "UPDATE TRABAJADOR set ID_T=?, CONTRASENIA=?, NOMBRE=?, SUELDO=?";
	final String AÑADIR_PELICULA = "INSERT INTO PELICULA (ID_P, NOMBRE, PRECIO, DURACION, CALIFICACION, ID_G, ID_T) VALUES (?,?,?,?,?,?,?)";
	final String MODIFICAR_PELICULA = "UPDATE PELICULA (ID_P, NOMBRE, PRECIO, DURACION, CALIFICACION, ID_G, ID_T)";
	final String ELIMINAR_PELICULA = "DELETE from PELICULA where ID_P=?";
	final String LOGIN_CLIENTE = " Select * from Cliente where DNI = ? AND CONTRASENIA = ?";
	final String LEER_GENERO = "SELECT * from Genero";


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
	public Usuario login(Usuario usuario) throws LoginException {
		// Tenemos que definie el ResusultSet para recoger el resultado de la consulta
		ResultSet rs = null;
		Usuario usu = null;

		openConnection();


		try {
			//					if (tipo == "Trabajador") {
			//						stmt = con.prepareStatement(LOGIN_TRABAJADOR);
			//					}else {
			//						stmt = con.prepareStatement(LOGIN_CLIENTE);
			//					}
			stmt = con.prepareStatement(LOGIN_TRABAJADOR);
			stmt.setString(1, usuario.getIdentificacion());
			stmt.setString(2, usuario.getContrasenia());
			rs = stmt.executeQuery();


			if (!rs.next()) {
				stmt = con.prepareStatement(LOGIN_CLIENTE);
				stmt.setString(1, usuario.getIdentificacion());
				stmt.setString(2, usuario.getContrasenia());
				rs = stmt.executeQuery();

				if (!rs.next()) {
					throw new LoginException("Usuario o Password incorrecta");
				}else {
					usu = new Cliente();

				}
			}else {
				
				usu = new Trabajador();
				String tipo = rs.getString(5);
				Tipo tipoEnum = Tipo.valueOf(tipo);
				((Trabajador) usu).setTipo(tipoEnum);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				closeConnection();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return usu;
	}

	@Override
	public void altaTrabajador(Trabajador trab) {
		openConnection();
		try {
			stmt = con.prepareStatement(INSERTAR_TRABAJADOR);
			stmt.setString(1, trab.getIdentificacion());
			stmt.setString(2, trab.getContrasenia());
			stmt.setString(3, trab.getNombre());
			stmt.setFloat(4, trab.getSueldo());
			stmt.setString(5, trab.getTipo().toString());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Trabajador buscarTrabajador(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarTrabajador(Trabajador trab) {
		openConnection();
		try {
			stmt = con.prepareStatement(MODIFICAR_TRABAJADOR);
			stmt.setString(1, trab.getIdentificacion());
			stmt.setString(2, trab.getNombre());
			stmt.setString(3, trab.getContrasenia());
			stmt.setFloat(4, trab.getSueldo());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void eliminarTrabajador(Trabajador trab) {
		openConnection();
		try {
			stmt = con.prepareStatement(ELIMINAR_TRABAJADOR);
			stmt.setString(1, trab.getIdentificacion());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void añadirPelicula(Pelicula peli) {
		openConnection();
		try {
			stmt = con.prepareStatement(AÑADIR_PELICULA);
			stmt.setString(1, peli.getIdP());
			stmt.setString(2, peli.getNombre());
			stmt.setFloat(3, peli.getPrecio());
			stmt.setInt(4, peli.getDuracion());
			stmt.setFloat(5, peli.getCalificacion());
			stmt.setString(6,peli.getIdG());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Pelicula buscarPelicula(String idP) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarPelicula(Pelicula peli) {
		openConnection();
		try {
			stmt = con.prepareStatement(MODIFICAR_PELICULA);
			stmt.setString(1, peli.getIdP());
			stmt.setString(2, peli.getNombre());
			stmt.setFloat(3, peli.getPrecio());
			stmt.setInt(4, peli.getDuracion());
			stmt.setFloat(5, peli.getCalificacion());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void eliminarPeliculas(Pelicula peli) {
		openConnection();
		try {
			stmt = con.prepareStatement(ELIMINAR_PELICULA);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
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
			stmt.setString(1, clien.getIdentificacion());
			stmt.setString(2, clien.getNombre());
			stmt.setString(3, clien.getContrasenia());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error SQL Exception");
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}

	@Override
	public Map<String, Genero> listargenero() {
		HashMap<String, Genero> map = new HashMap<String,Genero>();
		ResultSet rs = null;
		openConnection();
		try {
			stmt = con.prepareStatement(LEER_GENERO);
			rs = stmt.executeQuery();
			Genero genero = new Genero();
			while (rs.next()) {
				//map.keySet().add(rs.getString(1));
				genero.setIdG(rs.getString(1));
				genero.setCategoria(rs.getString(2));
				map.put(rs.getString(1), genero);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
   }
}