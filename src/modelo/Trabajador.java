package modelo;

public class Trabajador {
	private String idT;
	private String contrasenia;
	private String nombre;
	private float sueldo;
	private Tipo tipo;
	
	public enum Tipo{
		Admin, Trabajador;
	}

	public String getIdT() {
		return idT;
	}

	public void setIdT(String idT) {
		this.idT = idT;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Trabajador [idT=" + idT + ", contrasenia=" + contrasenia + ", nombre=" + nombre + ", sueldo=" + sueldo
				+ ", tipo=" + tipo + "]";
	}
	
	
		
	
	

}
