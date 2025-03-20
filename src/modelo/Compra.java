package modelo;

public class Compra {
	private String dni;
	private String nombre;
	private String contrasenia;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	@Override
	public String toString() {
		return "Compra [dni=" + dni + ", nombre=" + nombre + ", contrasenia=" + contrasenia + "]";
	}
	
	

}
