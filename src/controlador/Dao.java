package controlador;

import java.util.Map;

import excepciones.LoginException;
import modelo.Cliente;
import modelo.Genero;
import modelo.Pelicula;
import modelo.Trabajador;
import modelo.Usuario;


public interface Dao {
	
	public Usuario login(Usuario trabajador) throws LoginException;
	 
	 public void altaTrabajador (Trabajador trab);
	 
	 public Trabajador buscarTrabajador(String id);
	 
	 public void modificarTrabajador(Trabajador id);
	 
	 public void eliminarTrabajador (Trabajador id);
	 
	 public void añadirPelicula (Pelicula peli);
	 
	 public void modificarPelicula (Pelicula copelic);
	 
	 public void eliminarPeliculas (Pelicula peli);
	 
	 public void altaClientes(Cliente clien);
	 
	 public Map<String, Genero> listargenero();
	 
	 public Map<String, Pelicula> listarPeliculas();
	 
	 public Map<String, Pelicula> listarPeliculasCompradas(Pelicula peli);

	Pelicula buscarPelicula(String idP);
	

}