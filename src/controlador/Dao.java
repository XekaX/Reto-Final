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
	 
	 public boolean altaTrabajador (Trabajador trab);
	 
	 public Trabajador buscarTrabajador(String id);
	 
	 public boolean modificarTrabajador(Trabajador id);
	 
	 public boolean eliminarTrabajador (Trabajador id);
	 
	 public boolean existeTrabajador(String id);
	 
	 public boolean añadirPelicula (Pelicula peli);
	 
	 public boolean modificarPelicula (Pelicula copelic);
	 
	 public boolean eliminarPeliculas (Pelicula peli);
	 
	 public boolean existePelicula(String id);
	 
	 public void altaClientes(Cliente clien) throws DniException;
	 
	 
	 public Map<String, Genero> listargenero();
	 
	public void comprar(Compra comp);

	public Map<String, Pelicula> listarPeliculas(Usuario clien);

	public Map<String, Pelicula> listarPeliculasCompradas(Usuario usu);

	public String obtenerMejorPelicula();

	boolean existeCliente(String dni);




	

}