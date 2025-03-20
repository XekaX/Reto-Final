package excepciones;

import javax.swing.JOptionPane;

public class LoginExcepction extends Exception {
private String mensaje;
	
		
	public void visualizarMensaje() {
		JOptionPane.showMessageDialog(null, this.mensaje, "ERROR", 0);
	}

}
