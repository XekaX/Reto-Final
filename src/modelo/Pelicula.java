package modelo;

public class Pelicula {
	private String idP;
	private String nombre;
	private float precio;
	private int duracion;
	private float calificacion;
	private String idG;
	
	
	public String getIdP() {
		return idP;
	}
	public void setIdP(String idP) {
		this.idP = idP;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public float getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}
	public String getIdG() {
		return idG;
	}
	public void setIdG(String idG) {
		this.idG = idG;
	}
	
	@Override
	public String toString() {
		return "Pelicula [idP=" + idP + ", nombre=" + nombre + ", precio=" + precio + ", duracion=" + duracion
				+ ", calificacion=" + calificacion + ", idG=" + idG + ", genero=" + "]";
	}

}
