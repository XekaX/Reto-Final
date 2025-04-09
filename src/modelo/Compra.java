package modelo;

import java.time.LocalDate;

public class Compra {
	private String dni;
	private String idP;
	private LocalDate fechaCompra;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getIdP() {
		return idP;
	}
	public void setIdP(String idP) {
		this.idP = idP;
	}
	public LocalDate getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	@Override
	public String toString() {
		return "Compra [dni=" + dni + ", nombre=" + idP + ", fechaCompra=" + fechaCompra + "]";
	}
}
	
	

