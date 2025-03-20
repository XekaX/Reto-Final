package controlador;


import modelo.Cliente;
import vista.VentanaPrincipal;

public class Principal {
	private static Dao dao = new DaoImplementacionMSql();

	public static void main(String[] args) {
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.setVisible(true);
	}

	public static void altaCliente(Cliente clien) {
		dao.altaClientes(clien);
	}

}


