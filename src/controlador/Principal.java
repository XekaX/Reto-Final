package controlador;

import java.util.HashMap;
import java.util.Map;

import excepciones.DniException;
import excepciones.LoginException;
import modelo.Cliente;
import modelo.Compra;
import modelo.Genero;
import modelo.Pelicula;
import modelo.Trabajador;
import modelo.Usuario;
import vista.VentanaLog;

public class Principal {
	private static Dao dao = new DaoImplementacionMSql();

	public static void main(String[] args) {
		VentanaLog ventana = new VentanaLog();
		ventana.setVisible(true);
		}

	public static Usuario login(Usuario trabajador) throws LoginException {
		Usuario usu = dao.login(trabajador);

		return usu;

	}

	public static void altaCliente(Cliente clien) throws DniException {
		dao.altaClientes(clien);
	}

	public static boolean altaTrabajador(Trabajador trab) {
		return dao.altaTrabajador(trab);

	}

	public static boolean bajaPropietario(Trabajador trab) {
	    return dao.eliminarTrabajador(trab);
	}

	public static boolean modificarTrabajador(Trabajador trab) {
	    return dao.modificarTrabajador(trab);
	}

	public static boolean existeTrabajador(String id) {
	    return dao.existeTrabajador(id);
	}

	public static boolean altaPelicula(Pelicula peli) {
		return dao.añadirPelicula(peli);
	}

	public static boolean eliminarPelicula(Pelicula peli) {
		return dao.eliminarPeliculas(peli);
	}

	public static boolean modificarPelicula(Pelicula peli) {
		return dao.modificarPelicula(peli);
	}
	
	public static boolean existePelicula(String id) {
	    return dao.existePelicula(id);
	}
	
	public static Map<String, Genero> recibirMapaGenero() {
		return dao.listargenero();
	}
	public static Map<String, Pelicula> listarPeliculas(Usuario clien) {
		return dao.listarPeliculas(clien);
	}
	public static Map<String, Pelicula> listarPeliculasCompradas(Usuario clien){
		return dao.listarPeliculasCompradas(clien);
	}
	public static void comprar(Compra comp) {
		dao.comprar(comp);
	}

	public static String obtenerMejorPelicula() {
		return dao.obtenerMejorPelicula();
	}
}



