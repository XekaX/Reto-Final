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
import modelo.Compra;
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
	//CLIENTE
	final String INSERTAR_CLIENTE = "INSERT INTO CLIENTE (DNI, NOMBRE, CONTRASENIA) VALUES (?,?,?)";
	final String LOGIN_CLIENTE = " Select * from Cliente where DNI = ? AND CONTRASENIA = ?";
	final String LEER_PELICULAS_COMPRADAS = "SELECT P.* FROM PELICULA P, COMPRA C WHERE P.ID_P = C.ID_P AND C.DNI = ?";
	final String COMPRAR_PELICULA = "INSERT INTO COMPRA (DNI, ID_P, FECHA_COMPRA) VALUES (?,?,?)";
	//TRABAJADOR
	final String INSERTAR_TRABAJADOR ="INSERT INTO TRABAJADOR (ID_T, CONTRASENIA, NOMBRE, SUELDO, TIPO) VALUES (?,?,?,?,?)";
	final String LOGIN_TRABAJADOR = "Select * from TRABAJADOR where ID_T = ? and CONTRASENIA = ?";
	final String ELIMINAR_TRABAJADOR = "DELETE from TRABAJADOR where ID_T=?";
	final String MODIFICAR_TRABAJADOR = "UPDATE TRABAJADOR set NOMBRE=?, CONTRASENIA=?, SUELDO=? WHERE ID_T=?";
	//PELICULA
	final String AÑADIR_PELICULA = "INSERT INTO PELICULA (ID_P, NOMBRE, PRECIO, DURACION, CALIFICACION, ID_G, ID_T) VALUES (?,?,?,?,?,?,?)";
	final String MODIFICAR_PELICULA = "UPDATE PELICULA SET PRECIO=?, CALIFICACION=? WHERE ID_P=?";
	final String ELIMINAR_PELICULA = "DELETE from PELICULA where ID_P=?";
	final String LEER_GENERO = "SELECT * from Genero";
    final String LEER_PELICULAS = "SELECT * FROM PELICULA WHERE ID_P NOT IN (SELECT ID_P FROM COMPRA WHERE DNI=?)";

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
					usu.setIdentificacion(rs.getString(1));

				}
			}else {
				
				usu = new Trabajador();
				String tipo = rs.getString(5);
				Tipo tipoEnum = Tipo.valueOf(tipo);
				((Trabajador) usu).setTipo(tipoEnum);
				usu.setIdentificacion(rs.getString(1));
				

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

	public void comprar(Compra comp) {
		openConnection();
		try {
			stmt = con.prepareStatement(COMPRAR_PELICULA);
			stmt.setString(1,comp.getDni());
			stmt.setString(2, comp.getIdP());
			stmt.setDate(3, Date.valueOf(comp.getFechaCompra()));
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
	public void modificarTrabajador(Trabajador trab) {
		openConnection();
		try {
			stmt = con.prepareStatement(MODIFICAR_TRABAJADOR);
			stmt.setString(1, trab.getNombre());
			stmt.setString(2, trab.getContrasenia());
			stmt.setFloat(3, trab.getSueldo());
			stmt.setString(4, trab.getIdentificacion());
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
			stmt.setString(7,peli.getIdT());
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
	public void modificarPelicula(Pelicula peli) {
		openConnection();
		try {
			stmt = con.prepareStatement(MODIFICAR_PELICULA);
			stmt.setFloat(1, peli.getPrecio());
			stmt.setFloat(2, peli.getCalificacion());
			stmt.setString(3, peli.getIdP());
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
			stmt.setString(1, peli.getIdP());
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
	public Map<String, Pelicula> listarPeliculas(Usuario clien) {
		Map<String, Pelicula> map = new HashMap<String,Pelicula>();
		ResultSet rs = null;
		Pelicula peli;
		openConnection();
		try {
			stmt = con.prepareStatement(LEER_PELICULAS);
			stmt.setString(1, clien.getIdentificacion());
			rs = stmt.executeQuery();
			while (rs.next()) {
				peli = new Pelicula();
				peli.setIdP(rs.getString("id_p"));
				peli.setNombre(rs.getString("Nombre"));
				peli.setPrecio(rs.getFloat("Precio"));
				peli.setDuracion(rs.getInt("Duracion"));
				peli.setCalificacion(rs.getFloat("Calificacion"));
				peli.setIdG(rs.getString("id_g"));
				peli.setIdT(rs.getString("id_t"));
				map.put(peli.getIdP(), peli);
			}
	
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

		
	@Override
	public Map<String, Pelicula> listarPeliculasCompradas(Usuario clien) {
		Map<String, Pelicula> pelisCompradasMap = new HashMap<String,Pelicula>();
		ResultSet rs = null;
		Pelicula peli;
		openConnection();
		try {
			stmt = con.prepareStatement(LEER_PELICULAS_COMPRADAS);
			stmt.setString(1, clien.getIdentificacion());
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				peli = new Pelicula();
				peli.setIdP(rs.getString("id_p"));
				peli.setNombre(rs.getString("Nombre"));
				peli.setPrecio(rs.getFloat("Precio"));
				peli.setDuracion(rs.getInt("Duracion"));
				peli.setCalificacion(rs.getFloat("Calificacion"));
				peli.setIdG(rs.getString("id_g"));
				peli.setIdT(rs.getString("id_t"));
				pelisCompradasMap.put(peli.getIdP(), peli);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pelisCompradasMap;
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
		Map<String, Genero> map = new HashMap<String,Genero>();
		ResultSet rs = null;
		openConnection();
		try {
			stmt = con.prepareStatement(LEER_GENERO);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Genero genero = new Genero();
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
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	@Override
	public Trabajador buscarTrabajador(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}