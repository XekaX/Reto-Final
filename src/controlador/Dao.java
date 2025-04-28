package controlador;

import java.util.Map;

import excepciones.DniException;
import excepciones.LoginException;
import modelo.Cliente;
import modelo.Compra;
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
	 
	 public void altaClientes(Cliente clien) throws DniException;
	 
	 public Map<String, Genero> listargenero();
	 
	public void comprar(Compra comp);

	public Map<String, Pelicula> listarPeliculas(Usuario clien);

	public Map<String, Pelicula> listarPeliculasCompradas(Usuario usu);

	public String obtenerMejorPelicula();

	

}