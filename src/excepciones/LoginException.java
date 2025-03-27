package excepciones;

import javax.swing.JOptionPane;

public class LoginException extends Exception {
    private String mensaje;
	
	public LoginException(String mensaje) {
		this.mensaje = mensaje;
		}
	
	public void visualizarMensaje() {
		JOptionPane.showMessageDialog(null, this.mensaje, "ERROR", 0);
	}

}
