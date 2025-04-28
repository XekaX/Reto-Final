package excepciones;

import javax.swing.JOptionPane;

public class DniException extends Exception {
	private String mensaje;
	
	public DniException(String mensaje) {
		this.mensaje = mensaje;
		}
	
	public void visualizarMensaje() {
		JOptionPane.showMessageDialog(null, this.mensaje, "ERROR", 0);
	}

}
