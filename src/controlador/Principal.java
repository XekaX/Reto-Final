package controlador;

import java.util.HashMap;
import java.util.Map;

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

	public static void altaCliente(Cliente clien) {
		dao.altaClientes(clien);
	}

	public static void altaTrabajador(Trabajador trab) {
		dao.altaTrabajador(trab);

	}

	public static void bajaPropietario(Trabajador trab) {
		dao.eliminarTrabajador(trab);

	}

	public static void modificarTrabajador(Trabajador trab) {
		dao.modificarTrabajador(trab);

	}

	public static void altaPelicula(Pelicula peli) {
		dao.añadirPelicula(peli);
	}

	public static void eliminarPelicula(Pelicula peli) {
		dao.eliminarPeliculas(peli);
	}

	public static void modificarPelicula(Pelicula peli) {
		dao.modificarPelicula(peli);
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
}


