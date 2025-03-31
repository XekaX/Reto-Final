package modelo;

public class Genero {
	private String idG;
	private String categoria;
	
	public String getIdG() {
		return idG;
	}
	public void setIdG(String idG) {
		this.idG = idG;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Genero [idG=" + idG + ", categoria=" + categoria + "]";
	}
	
	

}
